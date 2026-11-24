package com.example.phase2.view;

import com.example.phase2.controller.MainMenuController;
import com.example.phase2.controller.RestaurantMenuForUserController;
import com.example.phase2.controller.UserMenuController;
import com.example.phase2.model.DataBase;

import java.util.regex.Matcher;

public class UserMenu {
    private UserMenuController userMenuController;
    private RestaurantMenuForUser restaurantMenuForUser;

    public UserMenu() {
        userMenuController = new UserMenuController();
        restaurantMenuForUser = new RestaurantMenuForUser();
    }

    public void run() {
        String command;
        Matcher matcher;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to main menu\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+all\\s+restaurants\\s*$")) != null) {
                userMenuController.showAllRestaurantsForUser();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*search\\s+restaurant\\s+(?<restaurantName>\\s*$")) != null) {
                userMenuController.searchRestaurantName(matcher.group("restaurantName"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+(?<restaurantID>\\s*$")) != null) {
                int id = Integer.parseInt(matcher.group("restaurantID"));
                DataBase.setCurrentRestaurantForUser(DataBase.getRestaurantByIdInCurrentUser(id));
                restaurantMenuForUser.run(DataBase.getCurrentRestaurantForUser());
            }
        }
    }
}
