package com.example.lab6;

public class Meal {
    private String title;
    private String subtitle;
    private int imageResId;
    private int price;

    public Meal(String title, String subtitle, int price, int imageResId) {
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }
}
