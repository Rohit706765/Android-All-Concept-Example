package com.example.androidconcept.Reterofit;

import com.google.gson.annotations.SerializedName;

/* this class also called pojo class */

public class Post {
    private int id;
    private int userID;
    private String title;

    public Post(int userID, String title, String text) {

        this.userID = userID;
        this.title = title;
        this.text = text;
    }

    @SerializedName("body")  // for identify to the api
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return text;
    }

    public void setBody(String body) {
        this.text = body;
    }
}
