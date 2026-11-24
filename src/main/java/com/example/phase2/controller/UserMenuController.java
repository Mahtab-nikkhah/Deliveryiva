package  com.example.phase2.controller;

import   com.example.phase2.model.DataBase;

public class UserMenuController {

    public void showAllRestaurantsForUser() {
        DataBase.getAllRestaurantsName();
    }

    public void searchRestaurantName(String nameOfRestaurant) {
        DataBase.showSearchedRestaurants(nameOfRestaurant);
    }
}
