package com.example.orange_android_course_final_project;

public class cartModel {
    private String img;
    private String title;
    private String counter;
    private String price;

    public cartModel(String img, String title, String counter, String price) {
        this.img = img;
        this.title = title;
        this.counter = counter;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getCounter() {
        return counter;
    }

    public String getPrice() {
        return price;
    }
}
