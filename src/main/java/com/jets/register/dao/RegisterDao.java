package com.jets.register.dao;

import com.jets.entity.Customers;
import com.jets.factory.EntityManagerProvider;
import com.jets.register.dto.RegisterDto;

import jakarta.persistence.EntityManager;

public class RegisterDao {
    EntityManagerProvider provider = EntityManagerProvider.getInstance();
    EntityManager em = provider.getEntityManager();

    public void register(RegisterDto registerDto) {
        Customers customer = new Customers();
        customer.setName(registerDto.getName());
        customer.setEmail(registerDto.getEmail());
        customer.setGender(registerDto.getGender());
        customer.setPassword(registerDto.getPassword());
        beginTransaction();
        em.persist(customer);
        commit();

    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
}
