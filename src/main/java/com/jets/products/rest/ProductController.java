package com.jets.products.rest;

import java.util.List;

import com.jets.categories.dtos.CategoryDto;
import com.jets.entity.Categories;
import com.jets.entity.Products;
import com.jets.login.CheckerDao;
import com.jets.mappers.Mapper;
import com.jets.products.daos.ProductDao;
import com.jets.products.dto.ProductDto;
import com.jets.products.dto.ProductPostDto;
import com.jets.products.dto.XmlProducts;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("products")
public class ProductController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductsAsJson(@HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.getLoggedInCustomer(uuid);
        if (customer != null) {
            ProductDao productDao = new ProductDao();
            var products = productDao.getAllProducts();
            if (products != null) {
                return Response.ok().entity(products).build();
            }
        }
        throw new NotFoundException("Products not found");
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getAllProductsAsXml(@HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.getLoggedInCustomer(uuid);
        if (customer != null) {
            ProductDao productDao = new ProductDao();
            var products = productDao.getAllProducts();
            var result = new XmlProducts();
            result.setProducts(products);
            if (products != null) {
                return Response.ok().entity(result).build();
            }
        }
        throw new NotFoundException("Products not found");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") int id, @HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.getLoggedInCustomer(uuid);
        if (customer != null) {
            ProductDao productDao = new ProductDao();
            Products product = productDao.getProductById(id);
            ProductDto productDto = Mapper.convertProductEntityToProductDto(product);
            if (product != null) {
                System.out.println(product.toString());
                return Response.ok().entity(productDto).build();
            }
        }
        throw new NotFoundException("Product not found");

    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") int id, @HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var employee = checkerDao.getLoggedInEmployee(uuid);
        if (employee.getRole().equalsIgnoreCase("admin")) {
            ProductDao productDao = new ProductDao();
            Products product = productDao.deleteProductById(id);
            ProductDto productDto = Mapper.convertProductEntityToProductDto(product);
            if (product != null) {
                return Response.ok().entity(productDto).build();
            }
        }
        throw new NotFoundException("Product not found");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(ProductPostDto productPostDto, @HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var employee = checkerDao.getLoggedInEmployee(uuid);
        if (employee.getRole().equalsIgnoreCase("admin")) {
            ProductDao productDao = new ProductDao();
            productDao.addProduct(productPostDto);
        }
    }

    @GET
    @Path("{id}/category")
    public Response getProductCategory(@PathParam("id") int id, @HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.getLoggedInCustomer(uuid);
        if (customer != null) {
            ProductDao productDao = new ProductDao();
            Products product = productDao.getProductById(id);
            Categories category = product.getCategories();
            CategoryDto categoryDto = Mapper.convertCategoryEntityToCategoryDto(category);
            return Response.ok().entity(categoryDto).build();
        }
        return Response.ok().entity("not logged in").build();
    }

    @GET
    @Path("search")
    public Response searchProductByPattern(@QueryParam("pattern") String pattern,  @HeaderParam("LoginId") String uuid) {
          
           CheckerDao checkerDao = new CheckerDao();
          var customer = checkerDao.getLoggedInCustomer(uuid);
         if (customer != null) {
            ProductDao productDao = new ProductDao();
            List<ProductDto> matchedProducts = productDao.searchProductsByPattern(pattern);
            return Response.ok().entity(matchedProducts).build();
         }
           return Response.ok().entity("login first").build();
}
}
