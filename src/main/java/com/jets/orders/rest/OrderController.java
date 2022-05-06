package com.jets.orders.rest;

import java.util.List;

import com.jets.orders.dao.OrderDao;
import com.jets.orders.dto.OrderItem;

import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.core.Response;

@Path("orders")
public class OrderController {
    @POST
    public Response makeOrder(List<OrderItem> items, @HeaderParam("LoginId") String loginId) {
        OrderDao orderDao = new OrderDao();
        var customer = orderDao.getLoggedInCustomer(loginId);
        if (customer != null) {
            orderDao.makeOrder(items, customer);

            return Response.ok().entity("order is done").build();
        }
        return Response.ok().entity("Order Failed ").build();
    }
}
