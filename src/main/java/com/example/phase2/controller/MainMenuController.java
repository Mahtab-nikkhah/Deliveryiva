package com.example.phase2.controller;

import com.example.phase2.HelloApplication;
import com.example.phase2.model.Admin;
import com.example.phase2.model.DataBase;
import com.example.phase2.model.Delivery;
import com.example.phase2.model.User;
import com.example.phase2.view.MainMenu;
import com.example.phase2.view.AdminMenu;
import com.example.phase2.view.DeliveryMenu;
import com.example.phase2.view.UserMenu;
import com.example.phase2.view.LoginMenu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    private User loggedInUser;
    private Admin loggedInAdmin;
    private Delivery loggedInDelivery;
    private final LoginMenu loginMenu;
    private final AdminMenu adminMenu;
    private final MainMenu mainMenu;
    private final UserMenu userMenu;
    private final DeliveryMenu deliveryMenu;


    public boolean isLoggedInUser() {
        return loggedInUser != null;
    }

    public MainMenuController() {
        loginMenu = new LoginMenu(this);
        userMenu = new UserMenu();
        deliveryMenu = new DeliveryMenu();
        mainMenu = new MainMenu(this);
        adminMenu = new AdminMenu();
    }


    public void run() {
        if (loginMenu.run().equals("exit")) return;
        while (true) {
            switch (mainMenu.run()) {
                case "admin menu":
                    adminMenu.run();
                    break;
                case "user menu":
                    userMenu.run();
                    break;
                case "delivery menu":
                    deliveryMenu.run();
                    break;
                case "logout":
                    if (loginMenu.run().equals("exit")) return;
                    break;
            }

        }
    }


    public String register(String username, String password, String securityQuestion, String securityAnswer) {
        if (this.role.equals("user") && DataBase.getUserByUsername(username) != null)
            return "register failed: username already exists";
        if (this.role.equals("admin") && DataBase.getAdminByUsername(username) != null)
            return "register failed: username already exists";
        if (this.role.equals("delivery") && DataBase.getDeliveryByUsername(username) != null)
            return "register failed: username already exists";
        if (password.length() < 5 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[0-9].*"))
            return "register failed: password is weak";
        if (this.role.equals("admin"))
            DataBase.addAdmin(username, password, securityQuestion, securityAnswer);
        else if (this.role.equals("user"))
            DataBase.addUser(username, password, securityQuestion, securityAnswer);
        else if (this.role.equals("delivery"))
            DataBase.addDelivery(username, password, securityQuestion, securityAnswer);
        else
            return "register failed: invalid role!";
        return "register successful";
    }

    public String login(String username, String password) {
        if (this.role.equals("user") && (loggedInUser = DataBase.getUserByUsername(username)) != null) {
            if (!loggedInUser.isPasswordCorrect(password)) {
                loggedInUser = null;
                return "login failed: incorrect password!";
            }
            DataBase.setCurrentUser(loggedInUser);
            return "login successful";
        } else if (this.role.equals("admin") && (loggedInAdmin = DataBase.getAdminByUsername(username)) != null) {
            if (!loggedInAdmin.isPasswordCorrect(password)) {
                loggedInAdmin = null;
                return "login failed: incorrect password!";
            }
            DataBase.setCurrentAdmin(loggedInAdmin);
            return "login successful";
        } else if (this.role.equals("delivery") && (loggedInDelivery = DataBase.getDeliveryByUsername(username)) != null) {
            if (!loggedInDelivery.isPasswordCorrect(password)) {
                loggedInDelivery = null;
                return "login failed: incorrect password!";
            }
            return "login successful";
        } else
            return "login failed: user not found!";
    }

    public String forgetPassword(String username, String securityAnswer, String newPassword) {
        if (this.role.equals("user") && DataBase.getUserByUsername(username) == null)
            return "Change failed: username does not exist";
        if (this.role.equals("admin") && DataBase.getAdminByUsername(username) == null)
            return "Change failed: username does not exist";
        if (this.role.equals("delivery") && DataBase.getDeliveryByUsername(username) == null)
            return "Change failed: username does not exist";
        if (this.role.equals("user") && DataBase.getUserByUsername(username).getSecurityAnswer().equals(securityAnswer)) {
            if (newPassword.length() < 5 || !newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[a-z].*") || !newPassword.matches(".*[0-9].*"))
                return "register failed: password is weak";
            else DataBase.getUserByUsername(username).setPassword(newPassword);
        }
        if (role.equals("admin") && DataBase.getAdminByUsername(username).getSecurityAnswer().equals(securityAnswer)) {
            if (newPassword.length() < 5 || !newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[a-z].*") || !newPassword.matches(".*[0-9].*"))
                return "register failed: password is weak";
            else DataBase.getAdminByUsername(username).setPassword(newPassword);
        }
        if (role.equals("delivery") && DataBase.getDeliveryByUsername(username).getSecurityAnswer().equals(securityAnswer)) {
            if (newPassword.length() < 5 || !newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[a-z].*") || !newPassword.matches(".*[0-9].*"))
                return "register failed: password is weak";
            else DataBase.getDeliveryByUsername(username).setPassword(newPassword);
        }
        return "Password Changed successfully";
    }

    public String logout() {
        loggedInUser = null;
        loggedInAdmin = null;
        loggedInDelivery = null;
        return "logout successful";
    }

    @FXML
    private void login(MouseEvent mouseEvent) throws IOException {
        loginMenu.start(HelloApplication.stage, "LoginMenu.fxml");
    }

    @FXML
    private void register(MouseEvent mouseEvent) throws IOException {
        loginMenu.start(HelloApplication.stage, "RegisterMenu.fxml");
    }

    @FXML
    private Button userButton;
    @FXML
    private Button adminButton;
    @FXML
    private Button deliveryButton;

    @FXML
    private void unselected1(MouseEvent mouseEvent) {
        String style = "-fx-font-size: 20; -fx-background-color: linear-gradient(to bottom right,magenta, aqua); -fx-background-radius: 20; -fx-text-fill: white;";
        userButton.setStyle(style);


    }

    @FXML
    private void selected1(MouseEvent mouseEvent) {
        String style = "-fx-font-size: 20; -fx-background-color: aqua; -fx-background-radius: 20; -fx-text-fill: white;";
        userButton.setStyle(style);

    }

    @FXML
    private void unselected2(MouseEvent mouseEvent) {
        String style = "-fx-font-size: 20; -fx-background-color: linear-gradient(to bottom right,magenta, aqua); -fx-background-radius: 20; -fx-text-fill: white;";
        adminButton.setStyle(style);

    }

    @FXML
    private void selected2(MouseEvent mouseEvent) {
        String style = "-fx-font-size: 20; -fx-background-color: aqua; -fx-background-radius: 20; -fx-text-fill: white;";

        adminButton.setStyle(style);
    }

    @FXML
    private void unselected3(MouseEvent mouseEvent) {
        String style = "-fx-font-size: 20; -fx-background-color: linear-gradient(to bottom right,magenta, aqua); -fx-background-radius: 20; -fx-text-fill: white;";

        deliveryButton.setStyle(style);

    }

    @FXML
    private void selected3(MouseEvent mouseEvent) {
        String style = "-fx-font-size: 20; -fx-background-color: aqua; -fx-background-radius: 20; -fx-text-fill: white;";

        deliveryButton.setStyle(style);
    }

    private String role = "null";

    @FXML
    private void role1(MouseEvent mouseEvent) {
        this.role = "user";
    }

    @FXML
    private void role2(MouseEvent mouseEvent) {
        this.role = "admin";

    }

    @FXML
    private void role3(MouseEvent mouseEvent) {
        this.role = "delivery";
    }

    @FXML
    private PasswordField password;
    @FXML
    private TextField securityAnswer;
    @FXML
    private TextField username;
    @FXML
    private TextField securityQuestion;
    @FXML
    private Button submit;

    @FXML
    private void submit(MouseEvent mouseEvent) {
        if (this.role.equals("null")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("role is null");
            alert.setContentText("choose your role!");
            alert.showAndWait();
        } else if (username.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("username");
            alert.setContentText("username field is empty!");
            alert.showAndWait();
        } else if (password.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("password");
            alert.setContentText("password field is empty!");
            alert.showAndWait();

        } else if (securityQuestion.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("securityQuestion");
            alert.setContentText("Security question field is empty!");
            alert.showAndWait();

        } else if (securityAnswer.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("securityAnswer");
            alert.setContentText("Security answer field is empty!");
            alert.showAndWait();

        } else if (password.getText().length() < 5 || !password.getText().matches(".*[A-Z].*") || !password.getText().matches(".*[a-z].*") || !password.getText().matches(".*[0-9].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("password");
            alert.setHeaderText("password is weak!");
            alert.setContentText("Use numbers, lowercase, and uppercase letters (minimum 5 characters).");
            alert.showAndWait();
        } else {
            if (this.role.equals("delivery") && DataBase.getDeliveryByUsername(username.getText()) != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("register failed");
                alert.setContentText("username already exists!");
                alert.showAndWait();
            } else if (this.role.equals("user") && DataBase.getUserByUsername(username.getText()) != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("register failed");
                alert.setContentText("username already exists!");
                alert.showAndWait();
            } else if (this.role.equals("admin") && DataBase.getAdminByUsername(username.getText()) != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("register failed");
                alert.setContentText("username already exists!");
                alert.showAndWait();
            } else {
                if (this.role.equals("admin"))
                    DataBase.addAdmin(username.getText(), password.getText(), securityQuestion.getText(), securityAnswer.getText());
                else if (this.role.equals("user"))
                    DataBase.addUser(username.getText(), password.getText(), securityQuestion.getText(), securityAnswer.getText());
                else if (this.role.equals("delivery"))
                    DataBase.addDelivery(username.getText(), password.getText(), securityQuestion.getText(), securityAnswer.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("registered");
                alert.setContentText("register successful!");
                alert.showAndWait();

            }
///change scene
        }


    }

    @FXML
    private void selected4(MouseEvent mouseEvent) {
        String style = "-fx-font-size: 20; -fx-background-color: aqua; -fx-background-radius: 20; -fx-text-fill: white;";

        submit.setStyle(style);
    }

    @FXML
    private void unselected4(MouseEvent mouseEvent) {
        String style = "-fx-font-size: 20; -fx-background-color: linear-gradient(to bottom right,magenta, aqua); -fx-background-radius: 20; -fx-text-fill: white;";
        submit.setStyle(style);
    }


}





