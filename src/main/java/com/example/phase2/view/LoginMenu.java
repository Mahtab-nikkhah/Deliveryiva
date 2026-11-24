package  com.example.phase2.view;
import com.example.phase2.HelloApplication;
import   com.example.phase2.controller.MainMenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
    public class LoginMenu {
    private MainMenuController mainMenuController;
    public LoginMenu(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
        public void start(Stage stage,String fxml) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            stage.setResizable(false);
            stage.setTitle("Deliveryiva");
            stage.setScene(scene);
            stage.show();
        }
    public String run(){
        Matcher matcher;
        String command, result;

        while (true){
            command = Menu.getScanner().nextLine();
            if(command.matches("\\s*(e|E)(x|X)(i|I)(T|t)\\s*")){System.out.println("BYE!");
                return "exit";}
            if ((matcher = Menu.getMatcher(command, "^\\s*(ADD|add|Add)\\s+(?<role>\\S+)\\s+(?<username>\\S+)\\s+(?<password>\\S+)\\s+(?<securityQuestion>\\S+)\\s+(?<securityAnswer>\\S+)\\s*$")) != null){
                System.out.println(mainMenuController.register(
                        matcher.group("username"),
                        matcher.group("password"),
                        matcher.group("securityQuestion"),
                        matcher.group("securityAnswer")));
            }
            else if ((matcher = Menu.getMatcher(command, "^\\s*(LOGIN|Login|login)\\s+(?<role>\\S+)\\s+(?<username>\\S+)\\s+(?<password>\\S+)\\s*$")) != null){
                result = mainMenuController.login(
                        matcher.group("username"),
                        matcher.group("password"));
                System.out.println(mainMenuController.login(
                        matcher.group("username"),
                        matcher.group("password")));
                if (result.equals("login successful"))
                    return "Logged in";
            }
            else if ((matcher = Menu.getMatcher(command, "^\\s*(FORGET|Forget|forget)\\s+(PASSWORD|Password|password)\\s+(?<role>\\S+)\\s+(?<username>\\S+)\\s+(?<securityAnswer>\\S+)\\s+(?<newPassword>\\S+)\\s*$")) != null){
                System.out.println(mainMenuController.forgetPassword(
                        matcher.group("username"),
                        matcher.group("securityAnswer"),
                        matcher.group("newPassword")));
            }
            else {
                System.out.println("invalid command!");
            }
        }
    }






}
