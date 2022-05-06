package com.jets.customers.dao;
import java.util.List;
import java.util.stream.Collectors;

import com.jets.customers.dto.CustomerDto;
import com.jets.customers.dto.CustomerGetDto;
import com.jets.entity.Customers;
import com.jets.factory.EntityManagerProvider;
import com.jets.mappers.Mapper;

import jakarta.persistence.EntityManager;
public class CustomerDao {
    EntityManagerProvider provider = EntityManagerProvider.getInstance();
    EntityManager em = provider.getEntityManager();

    public void addCustomer(CustomerDto customerDto){
        Customers customer=new Customers();
        customer.setId(1);
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setPassword(customerDto.getPassword());
        beginTransaction();
        em.persist(customer);
        commit();
    }
    public CustomerGetDto getCustomerById(int id){
     Customers customer=   em.find(Customers.class, id);
     return Mapper.convertCustomerEntityToCustomerDto(customer);
    }

    public List<CustomerGetDto> getAllCustomers(){
       var customerList= em.createQuery("select c from Customers c", Customers.class).getResultList();
       return customerList.stream().map(Mapper::convertCustomerEntityToCustomerDto).collect(Collectors.toList());
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
    
}
