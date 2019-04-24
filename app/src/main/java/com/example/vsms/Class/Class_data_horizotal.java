package com.example.vsms.Class;

public class Class_data_horizotal {
    protected int image;
    protected String brand;
    protected Double price;
    protected Double discount;

    public int getImage_view(){return image;}
    public String getBrand(){return brand;}
    public Double getPrice(){return price;}
    public Double getDic(){return discount;}

    public void setImage(int image){
        this.image=image;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setPrice(Double price){
        this.price=price;
    }
    public void setDiscount(double discount){
        this.discount=discount;
    }
}
