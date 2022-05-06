package com.jets.customers.soap;

import java.util.List;

import com.jets.customers.dto.CustomerGetDto;

import jakarta.jws.WebService;
@WebService
public interface Customer {
    
    public CustomerGetDto getCustomerById(int id);
    public List<CustomerGetDto> getAllCustomers();
}
