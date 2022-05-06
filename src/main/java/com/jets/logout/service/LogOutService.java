package com.jets.logout.service;

import com.jets.logout.dao.LogOutDao;

public class LogOutService {
    
   private LogOutDao logOutDao;

public LogOutService(LogOutDao logOutDao) {
    this.logOutDao = logOutDao;
}
   
    public Boolean logOut(String uuid){
      return  logOutDao.logOut(uuid);
    }
}
