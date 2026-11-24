package com.example.phase2.model;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.ArrayList;

public class Order
{
    private String status;
    private ArrayList<Order> allOrders = new ArrayList<>();
    private ArrayList<Food> foods;
    private int id;
    private double cost;
    private boolean DoesHasDelivery;
    private Restaurant restaurant;
    private User user;
    private Node location;

    public Order(String status, ArrayList<Order> allOrders, ArrayList<Food> foods, int id, double cost) {
        this.status = status;
        this.allOrders = allOrders;
        this.foods = foods;
        this.id = id;
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Order> getAllOrders() {
        return allOrders;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public int getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAllOrders(ArrayList<Order> allOrders) {
        this.allOrders = allOrders;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
