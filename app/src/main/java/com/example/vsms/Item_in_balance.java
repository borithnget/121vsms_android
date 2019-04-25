package com.example.vsms;

public class Item_in_balance {

    private int image_view;
    private String brand;
    private int total;

    public Item_in_balance(int image_view, String brand, int total) {
        this.image_view = image_view;
        this.brand = brand;
        this.total = total;
    }

    public int getImage_view() {
        return image_view;
    }

    public String getBrand() {
        return brand;
    }

    public int getTotal() {
        return total;
    }

    public void setImage_view(int image_view) {
        this.image_view = image_view;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
