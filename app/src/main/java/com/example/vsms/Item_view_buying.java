package com.example.vsms;

public class Item_view_buying {
    private String name;
    private int photo;
    private String Posted;
    private String Amount;
    private String Color;
    private String Brand;
    private String Category;
    private String Year;

    public Item_view_buying(String name, int photo, String posted, String amount, String color, String brand, String category, String year){
        this.name = name;
        this.photo = photo;
        this.Posted = posted;
        this.Amount = amount;
        this.Color = color;
        this.Brand = brand;
        this.Category = category;
        this.Year = year;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto(){
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getPosted() {
        return Posted;
    }

    public void setPosted(String posted) {
        Posted = posted;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
