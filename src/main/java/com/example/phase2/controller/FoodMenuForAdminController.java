package  com.example.phase2.controller;

import   com.example.phase2.model.Comment;
import   com.example.phase2.model.DataBase;
import   com.example.phase2.model.Rate;
import   com.example.phase2.model.Response;


public class FoodMenuForAdminController {
    public FoodMenuForAdminController() {
    }

    public void showRating() {
        System.out.println("rates are:");
        for (Rate rate : DataBase.getCurrentFoodForAdmin().getRates()) {
            System.out.println(rate.getOutOfFive());
        }
    }

    public void showComments() {
        System.out.println("comments are:");
        for (Comment comment : DataBase.getCurrentFoodForAdmin().getComments()) {
            System.out.println(comment.getComment());
        }
    }

    public void addNewResponse(String commentId, String message) {
        int id = Integer.parseInt(commentId);
        Response response = new Response(message, id);
        DataBase.getCurrentFoodForAdmin().getCommentById(id).setResponse(response);
        DataBase.getCurrentAdmin().addResponse(response);
        System.out.println("response sent successfully");
    }

    public void editResponse(String commentId, String newMessage) {
        int id = Integer.parseInt(commentId);
        DataBase.getCurrentFoodForAdmin().getCommentById(id).getResponse().setFeedback(newMessage);
        System.out.println("response edited successfully");
    }
}
