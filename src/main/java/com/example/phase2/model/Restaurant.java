package com.example.phase2.model;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private Admin admin;
    private int id;
    private boolean isThereOrder;
    private Node location;
    private  ArrayList<Order> allOrders;
    private ArrayList<FoodType> restaurantType;
    private ArrayList<Food> menu;
    private ArrayList<Order> onlineOrder;

    public Restaurant(String name, Node location) {
        this.name = name;
        this.admin = admin;
        allOrders = new ArrayList<>();
        menu = new ArrayList<>();
        onlineOrder = new ArrayList<>();
        restaurantType = new ArrayList<>();
        this.id = id;
        this.location = location;
        this.isThereOrder = isThereOrder;
    }

    public boolean isThereOrder() {
        return isThereOrder;
    }

    public void setThereOrder(boolean thereOrder) {
        isThereOrder = thereOrder;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Node getLocation() {
        return location;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(Node location) {
        this.location = location;
    }

    public Admin getAdmin() {
        return admin;
    }



    public ArrayList<Order> getOrders() {
        return allOrders;
    }

    public ArrayList<FoodType> getRestaurantType() {
        return restaurantType;
    }

    public ArrayList<Food> getMenu() {
        return menu;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public void setOrders(ArrayList<Order> orders) {
        this.allOrders = orders;
    }

    public void setRestaurantType(ArrayList<FoodType> restaurantType) {
        this.restaurantType = restaurantType;
    }

    public void setMenu(ArrayList<Food> menu) {
        this.menu = menu;
    }
    public void selectMenuForShowingFoods(){
        for (Food food : menu) {
            System.out.println(food.getName() + food.getCost() + food.getId() + food.getDiscount());
        }
    }
    public Food getFoodById(int id){
        for (Food food : menu) {
            if(food.getId()==id)
                return food;
        }
        return null;
    }
    public void addFoodToMenu(Food food){
        menu.add(food);
    }

    public ArrayList<Order> getAllOrders() {
        return allOrders;
    }

    public ArrayList<Order> getOnlineOrder() {
        return onlineOrder;
    }
    public Order getOnlineOrderById(int id){
        for (Order order : onlineOrder) {
            if(order.getId()==id) return order;
        }
        return null;
    }
}
