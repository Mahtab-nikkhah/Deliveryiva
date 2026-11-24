package com.example.phase2.model;
import java.util.ArrayList;

public class User extends ParentUser {
    private int discount;
    private Node location;
     private static ArrayList<Order> orders = new ArrayList<>();
    public User(String username, String password, String securityQuestion, String securityAnswer) {
        super(username, password, securityQuestion, securityAnswer);
        this.discount = discount;

    }
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Node getLocation() {
        return location;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public void setLocation(Node location) {
        this.location = location;
    }

    public static void setOrders(ArrayList<Order> orders) {
        User.orders = orders;
    }
}
