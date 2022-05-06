package com.jets.orders.dao;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.List;

import com.jets.entity.Customers;
import com.jets.entity.OrderDetails;
import com.jets.entity.OrderDetailsId;
import com.jets.entity.Orders;
import com.jets.entity.Products;
import com.jets.factory.EntityManagerProvider;
import com.jets.orders.dto.OrderItem;

import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;

public class OrderDao {
    EntityManagerProvider provider = EntityManagerProvider.getInstance();
    EntityManager em = provider.getEntityManager();

    public void makeOrder(List<OrderItem> items, Customers customer) {
        // TypedQuery<Customers> query= em.createQuery("select c from Customers c where
        // c.name=:name and c.password=:password", Customers.class);

        Orders order = new Orders();

        order.setDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setCustomers(customer);

        beginTransaction();
        em.persist(order);
        for (OrderItem item : items) {
            var product = em.find(Products.class, item.getId());
            if (product != null) {

                OrderDetails orderDetails = new OrderDetails();
                OrderDetailsId orderDetailsId=new OrderDetailsId();
                orderDetailsId.setOrderId(order.getId());
                orderDetailsId.setProductId(product.getId());
                orderDetails.setId(orderDetailsId);
                orderDetails.setOrders(order);
                orderDetails.setQuantity(item.getQuantity());
                orderDetails.setProducts(product);
                em.persist(orderDetails);
            } else {
                em.clear();
                em.close();
                return;
            }

        }
        commit();

    }
    public Customers getLoggedInCustomer(String uuid){
      
        TypedQuery<Customers> query= em.createQuery("select c from Customers c where c.authtoken=:uuid", Customers.class);
        return query.setParameter("uuid", uuid).setMaxResults(1).getSingleResult();
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
}
