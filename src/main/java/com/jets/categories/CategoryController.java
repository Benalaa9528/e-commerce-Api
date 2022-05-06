package com.jets.categories;

import com.jets.categories.daos.CategoryDao;
import com.jets.login.CheckerDao;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("categories")
public class CategoryController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories(@HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.getLoggedInCustomer(uuid);
        if (customer != null) {
            CategoryDao categoryDao = new CategoryDao();
            var categories = categoryDao.getAllCategories();
            if (categories != null) {
                return Response.ok().entity(categories).build();
            }
        }
        return Response.ok().entity("login first").build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryById(@PathParam("id") int id, @HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.getLoggedInCustomer(uuid);
        if (customer != null) {
            CategoryDao categoryDao = new CategoryDao();
            var categories = categoryDao.getCategoryById(id);
            if (categories != null) {
                return Response.ok().entity(categories).build();
            }
        }
        return Response.ok().entity("login first").build();
    }
    @GET
    @Path("{id}/products")
    public Response getCategoryProducts(@PathParam("id") int id,@HeaderParam("LoginId") String uuid){
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.getLoggedInCustomer(uuid);
        if (customer != null) {
            CategoryDao categoryDao = new CategoryDao();
            var products = categoryDao.getCategoryProductsByCategoryId(id);
            if(products != null){
                return Response.ok().entity(products).build();
            }
        }
        return Response.ok().entity("no products found").build();
    }

}
