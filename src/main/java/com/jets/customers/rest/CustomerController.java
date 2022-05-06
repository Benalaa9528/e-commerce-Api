package com.jets.customers.rest;

import java.util.List;

import com.jets.customers.dao.CustomerDao;
import com.jets.customers.dto.CustomerDto;
import com.jets.customers.dto.CustomerGetDto;
import com.jets.customers.dto.XmlCustomers;
import com.jets.login.CheckerDao;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customers")
public class CustomerController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(CustomerDto customerDto) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.addCustomer(customerDto);
        return Response.ok().entity("customer is added").build();
    }

    @GET
    @Path("{id}")
    public Response getCustomerById(@PathParam("id") int id, @HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(uuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {
            CustomerDao customerDao = new CustomerDao();
            CustomerGetDto customerGetDto = customerDao.getCustomerById(id);
            return Response.ok().entity(customerGetDto).build();
        }
        return Response.ok().entity("you don't have access").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomersAsJson(@HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(uuid);
        if (emp != null) {
            var list = getCustomers();
            return Response.ok().entity(list).build();
        }
        return Response.ok().entity("you don't have access").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getAllCustomersAsXml(@HeaderParam("LoginId") String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(uuid);
        if (emp != null) {
            var list = getCustomers();
            XmlCustomers xmlCustomers = new XmlCustomers();
            xmlCustomers.setCustomers(list);
            return Response.ok().entity(xmlCustomers).build();
        }
        return Response.ok().entity(" you don't have access").build();
    }

    private List<CustomerGetDto> getCustomers() {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.getAllCustomers();
    }
}
