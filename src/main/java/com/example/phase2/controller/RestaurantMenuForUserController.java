package  com.example.phase2.controller;

import   com.example.phase2.model.Food;
import   com.example.phase2.model.DataBase;

public class RestaurantMenuForUserController {
    public void showFoodMenuOfRestaurant(){
        for (Food food : DataBase.getCurrentRestaurantForUser().getMenu()) {
            System.out.println(food.getName() + food.getCost());
        }
    }
}
