package com.example.phase2.view;

import com.example.phase2.controller.RestaurantMenuForAdminController;
import com.example.phase2.model.DataBase;
import com.example.phase2.model.Restaurant;


import java.util.regex.Matcher;

public class RestaurantMenuForAdmin {
    private RestaurantMenuForAdminController restaurantMenuForAdminController;
    private FoodMenuForAdmin foodMenuForAdmin;

    public RestaurantMenuForAdmin() {
        restaurantMenuForAdminController = new RestaurantMenuForAdminController();
        foodMenuForAdmin = new FoodMenuForAdmin();
    }

    public void run(Restaurant currentRestaurant) {
        String command;
        Matcher matcher;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("\\s*back to admin menu\\s*")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+restaurant\\s+location\\s*$")) != null) {
                restaurantMenuForAdminController.showRestaurantLocation();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+restaurant\\s+location\\s+(?<new_location>\\s*$")) != null) {
                restaurantMenuForAdminController.editRestaurantLocation(matcher.group("new_location"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+restaurant\\s+foodtype\\s*$")) != null) {
                restaurantMenuForAdminController.showRestaurantFoodType();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+restaurant\\s+foodtype\\s*$")) != null) {
                restaurantMenuForAdminController.editRestaurantFoodType();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+menu\\s*$")) != null) {
                restaurantMenuForAdminController.selectMenuOfRestaurant();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+food\\s+(?<food_id>\\s+Name\\s+(?<new_name>\\s*$")) != null) {
                restaurantMenuForAdminController.editFoodName(matcher.group("food_id"), matcher.group("new name"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+food\\s+(?<food_id>\\s+Price\\s+(?<new_price>\\s*$")) != null) {
                restaurantMenuForAdminController.editFoodPrice(matcher.group("food id"), matcher.group("new_price"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*ADD\\s+food\\s+(?<food_name>\\s+(?<food_price>\\s*$")) != null) {
                restaurantMenuForAdminController.addFoodToRestaurant(matcher.group("food_name"), matcher.group("food_price"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*delete\\s+food\\s+(?<food_id>\\s*$")) != null) {
                restaurantMenuForAdminController.deleteFoodFromRestaurant(matcher.group(" food_id"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*deactivate\\s+food\\s+(?<food_id>\\s*$")) != null) {
                restaurantMenuForAdminController.deactivateFoodFromRestaurant(matcher.group("food_id"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*active\\s+food\\s+(?<food_id>\\s*$")) != null) {
                restaurantMenuForAdminController.activeFoodFromRestaurant(matcher.group("food_id"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*DISCOUNT\\s+FOOD\\s+(?<food_id>\\S+)\\s+(?<discount_percent>\\S+)\\s+(?<timestamp>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.discountFood(matcher.group("food_id"), matcher.group("discount_percent"), matcher.group("timestamp"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*DELETE\\s+DISCOUNT\\s+FOOD\\s+(?<food_id>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.deleteDiscountFood(matcher.group("food_id"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+open\\s+orders\\s*$")) != null) {
                restaurantMenuForAdminController.displayOnlineOrders();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+order\\s+(?<order_id>\\s*$")) != null) {
                restaurantMenuForAdminController.editOnlineOrder(matcher.group("order_id"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+order\\s+history\\s*$")) != null) {
                restaurantMenuForAdminController.showOrderHistory();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+food\\s+(?<food_id>\\s*$")) != null) {
                int id = Integer.parseInt(matcher.group("food_id"));
                DataBase.setCurrentFoodForAdmin(DataBase.getCurrentRestaurantForAdmin().getFoodById(id));
                foodMenuForAdmin.run(DataBase.getCurrentFoodForAdmin());
            }

        }
    }
}

