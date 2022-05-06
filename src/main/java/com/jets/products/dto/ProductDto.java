package com.jets.products.dto;

public class ProductDto {
    
    
    private String name;
    private String decription;
    private long price;
    private String image;

   
   

    public ProductDto(String name, String decription, long price, String image) {
        this.name = name;
        this.decription = decription;
        this.price = price;
        this.image = image;
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

    public ProductDto() {
    }
 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
   
    
  
    
}
