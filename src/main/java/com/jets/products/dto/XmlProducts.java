package com.jets.products.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class XmlProducts {
    List<ProductDto> product=new ArrayList<>();

    public List<ProductDto> getProducts() {
        return product;
    }

    public void setProducts(List<ProductDto> products) {
        this.product = products;
    }
    
}
