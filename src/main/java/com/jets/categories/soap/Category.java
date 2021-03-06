package com.jets.categories.soap;

import java.util.List;

import com.jets.categories.dtos.Categories;
import com.jets.categories.dtos.CategoryDto;
import com.jets.products.dto.ProductDto;

import jakarta.jws.WebService;
@WebService
public interface Category {
    
    public Categories getAllCategories(String customerUuid);
    public CategoryDto getCategoryById(int id,String customerUuid);
    public List<ProductDto> getCategoryProductsByCategoryId(int id,String customerUuid);

       
    
}
