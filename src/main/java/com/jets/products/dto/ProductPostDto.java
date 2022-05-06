package com.jets.products.dto;

public class ProductPostDto {
    private String name;
    private String decription;
    private long price;
    private String image;
    private String category;
    private int quantity;

   
   

 

    public ProductPostDto() {
    }

    public ProductPostDto(String name, String decription, long price, String image, String category, int quantity) {
        this.name = name;
        this.decription = decription;
        this.price = price;
        this.image = image;
        this.category = category;
        this.quantity = quantity;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   
 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
   
    
  
    
}


