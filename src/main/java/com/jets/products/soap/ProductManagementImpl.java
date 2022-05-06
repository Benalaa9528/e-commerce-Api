package com.jets.products.soap;



import com.jets.products.daos.ProductDao;
import com.jets.products.dto.XmlProducts;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.jets.products.soap.ProductManagement")
public class ProductManagementImpl implements ProductManagement {

    @Override
    public XmlProducts getAllProducts() {
        ProductDao productDao = new ProductDao();
        var products = productDao.getAllProducts();
        var result=new XmlProducts();
        result.setProducts(products);
        return result;
    }
    
}
