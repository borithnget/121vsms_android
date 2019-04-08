package com.example.vsms.Class;

public class ProductPostData {

    private String productName;
    private int productImage;
    private String productPrice;
    private String condition;

    public ProductPostData(String name,int image,String price,String condition){
        this.productName=name;
        this.productImage=image;
        this.productPrice=price;
        this.condition=condition;
    }

    public String getProductName(){return productName;}
    public int getProductImage(){return productImage;}
    public String getProductPrice(){return productPrice;}
    public String getCondition(){return condition;}
    public void setProductName(String name){this.productName=name;}
    public void setProductImage(int image){this.productImage=image;}
    public void setPrice(String price){this.productPrice=price;}
    public void setCondition(String condition){this.condition=condition;}

}
