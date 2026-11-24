package com.example.phase2.model;

import java.net.CookieManager;
import java.util.ArrayList;

public class Food {
    private String name;
    private int id;
    private boolean isActive;
    private double cost;
    private double discount;
    private String comment;
    private int rating;
    private ArrayList<Comment> comments;
    private ArrayList<Rate> Rates;
    private double timestamp;
    private boolean isThereDiscount;


    public Food(String name, double cost) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.discount = discount;
        this.comment = comment;
        this.rating = rating;
        this.comments = new ArrayList<>();
        this.isActive = isActive;
        this.timestamp = timestamp;
        this.isThereDiscount = false;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public double getDiscount() {
        return discount;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public ArrayList<Comment> getCommentAndRatings() {
        return comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setCommentAndRatings(ArrayList<Comment> commentAndRatings) {
        this.comments = commentAndRatings;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public ArrayList<Rate> getRates() {
        return Rates;
    }

    public boolean isThereDiscount() {
        return isThereDiscount;
    }

    public void setThereDiscount(boolean thereDiscount) {
        isThereDiscount = thereDiscount;
    }
    public Comment getCommentById(int id){
        for (Comment comment : comments) {
            if(comment.getId()==id) return comment;
        }
        return null;
    }
}
