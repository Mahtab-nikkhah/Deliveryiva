package com.example.phase2.view;

import com.example.phase2.controller.RestaurantMenuForUserController;
import com.example.phase2.model.DataBase;
import com.example.phase2.model.Restaurant;

import java.util.regex.Matcher;

public class RestaurantMenuForUser {
    private RestaurantMenuForUserController restaurantMenuForUserController;
    public FoodMenuForUser foodMenuForUser;

    public RestaurantMenuForUser() {
        restaurantMenuForUserController = new RestaurantMenuForUserController();
        foodMenuForUser = new FoodMenuForUser();
    }

    public void run(Restaurant restaurant) {
        String command;
        Matcher matcher;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to user menu\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+restaurant\\s+menu\\s*$")) != null) {
                restaurantMenuForUserController.showFoodMenuOfRestaurant();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+(?<food_id>\\s*$")) != null) {
                int id = Integer.parseInt(matcher.group("food_id"));
                DataBase.setCurrentFoodForUser(DataBase.getCurrentRestaurantForUser().getFoodById(id));
                foodMenuForUser.run(DataBase.getCurrentFoodForUser());
            }
        }
    }
}
