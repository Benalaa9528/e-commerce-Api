package com.jets.customers.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class XmlCustomers {
    List<CustomerGetDto> customers=new ArrayList<>();

    public List<CustomerGetDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerGetDto> customers) {
        this.customers = customers;
    }
    
    
}
