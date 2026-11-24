package com.example.phase2.model;

import java.net.CookieManager;
import java.util.ArrayList;

public class Response {
    private String feedback;
    private ArrayList<Response> responses;
    private int commentId;
    private int id;
    private Admin admin;
    private Comment comment;

    public Response(String feedback, int commentId) {
        this.feedback = feedback;
        this.responses = responses;
        this.commentId = commentId;
        this.id = id;
        this.admin = admin;
        this.comment = comment;
    }

    public String getFeedback() {
        return feedback;
    }

    public ArrayList<Response> getResponses() {
        return responses;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getId() {
        return id;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setResponses(ArrayList<Response> responses) {
        this.responses = responses;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
