package com.jets.customers.soap;

import com.jets.customers.dao.CustomerDao;
import com.jets.customers.dto.CustomerGetDto;
import com.jets.customers.dto.XmlCustomers;
import com.jets.login.dao.CheckerDao;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.jets.customers.soap.Customer")
public class CustomerImpl implements Customer {

    @Override
    public CustomerGetDto getCustomerById(int id, String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {

            CustomerDao customerDao = new CustomerDao();
            var customer = customerDao.getCustomerById(id);
            if (customer != null)
                return customer;
        }
        return null;
    }

    @Override
    public XmlCustomers getAllCustomers(String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {
            CustomerDao customerDao = new CustomerDao();
            var customers = customerDao.getAllCustomers();
            XmlCustomers xmlCustomers = new XmlCustomers();
            xmlCustomers.setCustomers(customers);
            return xmlCustomers;
        }
        return null;
    }

}
