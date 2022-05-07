package com.jets.customers.soap;



import com.jets.customers.dto.CustomerGetDto;
import com.jets.customers.dto.XmlCustomers;

import jakarta.jws.WebService;
@WebService
public interface Customer {
    
    public CustomerGetDto getCustomerById(int id,String adminUuid);
    public XmlCustomers getAllCustomers(String adminUuid);
}
