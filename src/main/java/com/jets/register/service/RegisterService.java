package com.jets.register.service;

import com.jets.register.dao.RegisterDao;
import com.jets.register.dto.RegisterDto;

public class RegisterService {
    private RegisterDao registerDao;

    public RegisterService(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }
    public void registerCustomer(RegisterDto registerDto){
        registerDao.register(registerDto);
    }
}
