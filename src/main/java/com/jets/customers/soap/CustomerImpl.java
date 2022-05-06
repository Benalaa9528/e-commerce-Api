package com.jets.customers.soap;

import java.util.List;

import com.jets.customers.dao.CustomerDao;
import com.jets.customers.dto.CustomerGetDto;
import com.jets.login.CheckerDao;

import jakarta.jws.WebService;
@WebService(endpointInterface = "com.jets.customers.soap.Customer")
public class CustomerImpl implements Customer {

    @Override
    public CustomerGetDto getCustomerById(int id) {
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.findCustomerById(id);
        if (customer != null) {
            CustomerDao customerDao = new CustomerDao();
            return customerDao.getCustomerById(id);
        }
        return null;
    }

    @Override
    public List<CustomerGetDto> getAllCustomers() {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.getAllCustomers();
    }

}
