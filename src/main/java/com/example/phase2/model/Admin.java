package com.example.phase2.model;

import java.util.ArrayList;
import java.util.Collections;

public class Admin extends ParentUser{
    private  ArrayList<Restaurant> restaurants;
    private ArrayList<Response> responses;

    public Admin(String username, String password, String securityQuestion, String securityAnswer) {
        super(username, password, securityQuestion, securityAnswer);
        restaurants = new ArrayList<>();
        responses = new ArrayList<>();
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
    public void addRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }
    public  ArrayList<String> getRestaurantsSorted() {
        ArrayList <String> nameOfRestaurants = new ArrayList<>();
        for (int i=0; i<restaurants.size(); i++){
            nameOfRestaurants.add(restaurants.get(i).getName());
        }
        Collections.sort(nameOfRestaurants);
        return nameOfRestaurants;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
    public void addResponse(Response response){
        responses.add(response);
    }
}
