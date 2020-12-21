package com.example.tiki;

public class User {
    private int resourceImage;
    private String name;

    public User(int resourceImage, String name){
        this.name = name;
        this.resourceImage = resourceImage;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
