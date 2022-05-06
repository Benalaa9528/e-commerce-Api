package com.jets.login;

import java.util.UUID;

import com.jets.entity.Customers;
import com.jets.entity.Employees;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("login")
public class LoginController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response checkLogin(Credentials credentials) {
        CheckerDao checkerDao = new CheckerDao();
        Boolean isCustomer = checkerDao.isCustomer(credentials.getEmail(), credentials.getPassword());
        System.out.println(isCustomer);
        if (isCustomer) {

            Customers customer = checkerDao.findCustomer(credentials.getEmail());
            if (customer.getAuthtoken() == null) {
                UUID uuid = UUID.randomUUID();
                customer.setAuthtoken(uuid.toString());
                checkerDao.updateCustomer(customer);
            }
            return Response.ok().entity(customer.getAuthtoken()).build();
        }
        return checkEmployeeLogin(credentials);

    }

    private Response checkEmployeeLogin(Credentials credentials) {
        CheckerDao checkerDao = new CheckerDao();
        Boolean isEmployee = checkerDao.isEmployee(credentials.getEmail(), credentials.getPassword());

        if (isEmployee) {

            Employees employee = checkerDao.findEmployee(credentials.getEmail());
            if (employee.getAuthtoken() == null) {
                UUID uuid = UUID.randomUUID();
                employee.setAuthtoken(uuid.toString());
                checkerDao.updateEmployee(employee);
            }
            return Response.ok().entity(employee.getAuthtoken()).build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }
}
