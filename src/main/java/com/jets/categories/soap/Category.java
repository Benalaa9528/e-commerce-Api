package com.jets.categories.soap;

import java.util.List;

import com.jets.categories.dtos.CategoryDto;
import com.jets.products.dto.ProductDto;

import jakarta.jws.WebService;
@WebService
public interface Category {
    
    public List<CategoryDto> getAllCategories();
    public CategoryDto getCategoryById(int id);
    public List<ProductDto> getCategoryProductsByCategoryId(int id);

       
    
}