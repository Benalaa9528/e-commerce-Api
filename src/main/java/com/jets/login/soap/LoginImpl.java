package com.jets.login.soap;

import java.util.UUID;

import com.jets.entity.Customers;
import com.jets.login.dao.CheckerDao;
import com.jets.login.dto.Credentials;

import jakarta.jws.WebService;
@WebService(endpointInterface = "com.jets.login.soap.Login")
public class LoginImpl implements Login {

    @Override
    public String login(Credentials credentials) {
        CheckerDao checkerDao = new CheckerDao();
        Boolean isCustomer = checkerDao.isCustomer(credentials.getEmail(), credentials.getPassword());
        if (isCustomer) {
            Customers customer = checkerDao.findCustomer(credentials.getEmail());
            if (customer.getAuthtoken() == null) {
                UUID uuid = UUID.randomUUID();
                customer.setAuthtoken(uuid.toString());
                checkerDao.updateCustomer(customer);
                return customer.getAuthtoken();
            }
        }
        return "Log In Failed";
    }

}
