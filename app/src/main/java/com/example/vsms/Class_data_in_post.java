package com.example.vsms;

public class Class_data_in_post {

    private int image_view;
    private String brand,post_on,renew_on,price;

    public Class_data_in_post(int image_view, String brand, String post_on, String renew_on, String price) {
        this.image_view = image_view;
        this.brand = brand;
        this.post_on = post_on;
        this.renew_on = renew_on;
        this.price = price;
    }

    public int getImage_view() {
        return image_view;
    }

    public String getBrand() {
        return brand;
    }

    public String getPost_on() {
        return post_on;
    }

    public String getRenew_on() {
        return renew_on;
    }

    public String getPrice() {
        return price;
    }

    public void setImage_view(int image_view) {
        this.image_view = image_view;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPost_on(String post_on) {
        this.post_on = post_on;
    }

    public void setRenew_on(String renew_on) {
        this.renew_on = renew_on;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
