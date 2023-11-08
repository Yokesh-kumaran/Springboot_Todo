package com.example.Springboot.model;

public class Todo {
    public Todo() {
    }

    public Todo(int id, String item) {
        this.id = id;
        this.item = item;
    }

    private int id;
    private String item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
