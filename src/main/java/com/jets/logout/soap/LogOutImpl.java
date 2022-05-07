package com.jets.logout.soap;

import com.jets.login.dao.CheckerDao;
import com.jets.logout.dao.LogOutDao;
import com.jets.logout.service.LogOutService;

import jakarta.jws.WebService;
@WebService(endpointInterface = "com.jets.logout.soap.LogOut")
public class LogOutImpl implements LogOut {

    @Override
    public String logOut(String customerUuid) {
        try {
            // CheckerDao checkerDao=new CheckerDao();
            // checkerDao.getLoggedInCustomer(customerUuid);
            LogOutService logOutService=new LogOutService(new LogOutDao());
            logOutService.logOut(customerUuid);
        } catch (Exception e) {
            
        }
        return null;
    }
    
}
