package com.jets.products.soap;



import com.jets.categories.dtos.CategoryDto;
import com.jets.products.dto.ProductDto;
import com.jets.products.dto.XmlProducts;

import jakarta.jws.WebService;

@WebService
public interface ProductManagement {
    
    public XmlProducts getAllProducts(String uuid);
    public ProductDto getProductById(int id,String uuid);
    public CategoryDto getProductCategory(int id,String uuid);



    
}
