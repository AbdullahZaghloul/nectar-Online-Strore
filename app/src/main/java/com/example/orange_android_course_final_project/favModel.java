package com.example.orange_android_course_final_project;

public class favModel {
    private String fav_image;
    private String title;
    private String price;

    public favModel(String fav_image, String title, String price) {
        this.fav_image = fav_image;
        this.title = title;
        this.price = price;
    }

    public String getFav_image() {
        return fav_image;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }
}
