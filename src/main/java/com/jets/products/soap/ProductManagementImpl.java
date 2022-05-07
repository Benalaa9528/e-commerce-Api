package com.jets.products.soap;

import java.util.List;

import com.jets.categories.dtos.CategoryDto;
import com.jets.login.dao.CheckerDao;
import com.jets.products.daos.ProductDao;
import com.jets.products.dto.ProductDto;
import com.jets.products.dto.ProductPostDto;
import com.jets.products.dto.XmlProducts;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.jets.products.soap.ProductManagement")
public class ProductManagementImpl implements ProductManagement {

    @Override
    public XmlProducts getAllProducts(String uuid) {
        try {
            CheckerDao checkerDao = new CheckerDao();
            checkerDao.getLoggedInCustomer(uuid);
            ProductDao productDao = new ProductDao();
            var products = productDao.getAllProducts();
            var result = new XmlProducts();
            result.setProducts(products);
            return result;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ProductDto getProductById(int id, String uuid) {
        try {
            CheckerDao checkerDao = new CheckerDao();
            checkerDao.getLoggedInCustomer(uuid);
            ProductDao productDao = new ProductDao();
            var product = productDao.getProductById(id);
            if (product != null)
                return new ProductDto(product.getName(), product.getDescription(), product.getPrice(),
                        product.getImage());
        } catch (Exception e) {

        }
        return null;

    }

    @Override
    public CategoryDto getProductCategory(int id, String uuid) {
        try {
            CheckerDao checkerDao = new CheckerDao();
            checkerDao.getLoggedInCustomer(uuid);
            ProductDao productDao = new ProductDao();
            var category = productDao.getProductCategory(id);
            if (category != null)
                return category;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public XmlProducts searchProductByPattern(String pattern, String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.getLoggedInCustomer(uuid);
        if (customer != null) {
            ProductDao productDao = new ProductDao();
            List<ProductDto> matchedProducts = productDao.searchProductsByPattern(pattern);
            XmlProducts xmlProducts = new XmlProducts();
            xmlProducts.setProducts(matchedProducts);
            return xmlProducts;
        }

        return null;
    }

    @Override
    public String addProduct(ProductPostDto productPostDto, String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var employee = checkerDao.getLoggedInEmployee(uuid);
        if (employee.getRole().equalsIgnoreCase("admin")) {
            ProductDao productDao = new ProductDao();
            productDao.addProduct(productPostDto);
            return "Product Is Added Successfully";
        }
        return "Failed To Add Product";

    }

    @Override
    public String deleteProduct(int productId, String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var employee = checkerDao.getLoggedInEmployee(uuid);
        if (employee.getRole().equalsIgnoreCase("admin")) {
            ProductDao productDao = new ProductDao();
            productDao.deleteProductById(productId);
            return "Product Is Deleted ";

        }
        return null;
    }

}
