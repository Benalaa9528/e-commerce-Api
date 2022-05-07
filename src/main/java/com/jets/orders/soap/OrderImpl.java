package com.jets.orders.soap;

import java.util.List;

import com.jets.orders.dao.OrderDao;
import com.jets.orders.dto.OrderItem;

import jakarta.jws.WebService;
@WebService(endpointInterface = "com.jets.orders.soap.Order")
public class OrderImpl implements Order {

    @Override
    public String makeOrder(String customerUuid, List<OrderItem> items) {
        OrderDao orderDao = new OrderDao();
        try {
            var customer = orderDao.getLoggedInCustomer(customerUuid);
            orderDao.makeOrder(items, customer);
            return "Order Done ";

        } catch (Exception e) {
            return "Log In First";
        }
        
       
    }
    
}
