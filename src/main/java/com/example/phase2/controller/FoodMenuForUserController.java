package  com.example.phase2.controller;

import   com.example.phase2.model.DataBase;
import   com.example.phase2.model.Comment;

public class FoodMenuForUserController {
    public void showComments(){
        System.out.println("comments are:");
        for (Comment comment : DataBase.getCurrentFoodForUser().getComments()) {
            System.out.println(comment.getComment());
        }
    }
}
