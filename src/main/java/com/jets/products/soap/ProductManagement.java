package com.jets.products.soap;



import com.jets.categories.dtos.CategoryDto;
import com.jets.products.dto.ProductDto;
import com.jets.products.dto.XmlProducts;

import jakarta.jws.WebService;

@WebService
public interface ProductManagement {
    
    public XmlProducts getAllProducts();
    public ProductDto getProductById(int id);
    public CategoryDto getProductCategory(int id);



    
}
