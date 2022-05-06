package com.jets.mappers;

import com.jets.admin.dtos.AdminGetResponse;
import com.jets.categories.dtos.CategoryDto;
import com.jets.clerks.dto.ClerkDto;

import com.jets.customers.dto.CustomerGetDto;
import com.jets.entity.Categories;
import com.jets.entity.Customers;
import com.jets.entity.Employees;
import com.jets.entity.Products;
import com.jets.products.dto.ProductDto;

public class Mapper {
    
    public static ProductDto convertProductEntityToProductDto(Products product){
        return new ProductDto(product.getName(),product.getDescription() , product.getPrice(), product.getImage());
    }

    public static CategoryDto convertCategoryEntityToCategoryDto(Categories category){
        return new CategoryDto(category.getName(), category.getDescription());
    }
    public static ClerkDto convertEmployeeEntityToClerkDto(Employees clerk){
        return new ClerkDto(clerk.getId(),clerk.getName(),clerk.getEmail() , clerk.getRole());
    }
    public static CustomerGetDto convertCustomerEntityToCustomerDto(Customers customer){
        return new CustomerGetDto(customer.getId(),customer.getName(),customer.getEmail(),customer.getPassword());
    }
    
}
