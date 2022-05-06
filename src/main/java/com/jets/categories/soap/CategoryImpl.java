package com.jets.categories.soap;

import java.util.List;

import com.jets.categories.daos.CategoryDao;
import com.jets.categories.dtos.CategoryDto;
import com.jets.products.dto.ProductDto;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.jets.categories.soap.Category")
public class CategoryImpl implements Category {

    @Override
    public List<CategoryDto> getAllCategories() {
        CategoryDao categoryDao = new CategoryDao();
        var categories = categoryDao.getAllCategories();
        if(categories !=null){
            return categories;
        }
        return null;
    }

    @Override
    public CategoryDto getCategoryById(int id) {
        CategoryDao categoryDao = new CategoryDao();
        var category = categoryDao.getCategoryById(id);
        if(category != null){
            return category;
        }
        return null;
    }

    @Override
    public List<ProductDto> getCategoryProductsByCategoryId(int id) {
        CategoryDao categoryDao = new CategoryDao();
        var products = categoryDao.getCategoryProductsByCategoryId(id);
        if(products != null){
            return products;
        }
        return null;
    }
    
}
