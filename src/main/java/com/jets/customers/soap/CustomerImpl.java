package com.jets.customers.soap;



import com.jets.customers.dao.CustomerDao;
import com.jets.customers.dto.CustomerGetDto;
import com.jets.customers.dto.XmlCustomers;
import com.jets.login.dao.CheckerDao;

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
    public XmlCustomers getAllCustomers() {
        CustomerDao customerDao = new CustomerDao();
        var customers= customerDao.getAllCustomers();
        XmlCustomers xmlCustomers=new XmlCustomers();
        xmlCustomers.setCustomers(customers);
        return xmlCustomers;
    }

}
