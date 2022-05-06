package com.jets.products.soap;

import com.jets.categories.dtos.CategoryDto;
import com.jets.products.daos.ProductDao;
import com.jets.products.dto.ProductDto;
import com.jets.products.dto.XmlProducts;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.jets.products.soap.ProductManagement")
public class ProductManagementImpl implements ProductManagement {

    @Override
    public XmlProducts getAllProducts() {
        ProductDao productDao = new ProductDao();
        var products = productDao.getAllProducts();
        var result = new XmlProducts();
        result.setProducts(products);
        return result;
    }

    @Override
    public ProductDto getProductById(int id) {
        ProductDao productDao = new ProductDao();
        var product = productDao.getProductById(id);
        if (product != null)
            return new ProductDto(product.getName(), product.getDescription(), product.getPrice(), product.getImage());
        return null;
    }

    @Override
    public CategoryDto getProductCategory(int id) {
        ProductDao productDao = new ProductDao();
       var category= productDao.getProductCategory(id);
       if(category != null)
            return category;
        return null;
    }

}
