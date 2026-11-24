package com.example.phase2.model;

public class Comment {
    private int id;
    private String comment;
    private int rate;
    private Response response;

    public Comment(int id, String comment, int rate) {
        this.id = id;
        this.comment = comment;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public int getRate() {
        return rate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
