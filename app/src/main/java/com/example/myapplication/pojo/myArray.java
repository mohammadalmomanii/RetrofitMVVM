package com.example.myapplication.pojo;

public class myArray {
    private float userId;
    private float id;
    private String title;
    private String body;

    public myArray(float userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public float getUserId() {
        return userId;
    }

    public void setUserId(float userId) {
        this.userId = userId;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
