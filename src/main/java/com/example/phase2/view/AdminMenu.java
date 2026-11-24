package com.example.phase2.view;

import   com.example.phase2.controller.AdminMenuController;
import   com.example.phase2.model.DataBase;

import java.util.regex.Matcher;

public class AdminMenu {
    private AdminMenuController adminMenuController;
    private RestaurantMenuForAdmin restaurantMenuForAdmin;

    public AdminMenu() {
        adminMenuController = new AdminMenuController();
        restaurantMenuForAdmin = new RestaurantMenuForAdmin();
    }

    public void run() {
        Matcher matcher;
        String command;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*(b|B)(a|A)(c|C)(k|K)\\s+(T|t)(O|o)\\s+(m|M)(a|A)in\\s+(m|M)(e|E)(n|N)(u|U)\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+restaurant\\s+(?<restaurantName>\\S+)\\s+(?<location>\\S+)\\s*$")) != null) {
                adminMenuController.addRestaurant("restaurantName", "location");
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+all\\s+restaurants\\s*$")) != null) {
                adminMenuController.showAllRestaurants();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+restaurant\\s+(?<restaurantName>\\s*$")) != null) {
                String nameOfRestaurantSelected = "";
                DataBase.setCurrentRestaurantForAdmin(DataBase.getRestaurantByNameInCurrentAdmin(nameOfRestaurantSelected));
                restaurantMenuForAdmin.run(DataBase.getCurrentRestaurantForAdmin());
            }
        }
    }
}

