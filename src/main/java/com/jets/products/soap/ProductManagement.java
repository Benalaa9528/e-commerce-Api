package com.jets.products.soap;



import com.jets.products.dto.XmlProducts;

import jakarta.jws.WebService;

@WebService
public interface ProductManagement {
    
    public XmlProducts getAllProducts();

    
}
