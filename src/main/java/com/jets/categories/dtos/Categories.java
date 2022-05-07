package com.jets.categories.dtos;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Categories {
    
    List<CategoryDto> categories=new ArrayList<>();

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }
    
}
