package com.jets.orders.soap;

import java.util.List;

import com.jets.orders.dto.OrderItem;

import jakarta.jws.WebService;
@WebService
public interface Order {
    public String makeOrder(String customerUuid,List<OrderItem> items);
}
