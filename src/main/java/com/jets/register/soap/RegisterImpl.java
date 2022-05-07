package com.jets.register.soap;

import com.jets.register.dao.RegisterDao;
import com.jets.register.dto.RegisterDto;
import com.jets.register.service.RegisterService;

import jakarta.jws.WebService;
@WebService(endpointInterface = "com.jets.register.soap.Register")
public class RegisterImpl implements Register {

    @Override
    public String register(RegisterDto registerDto) {
        RegisterService service=new RegisterService(new RegisterDao());
        service.registerCustomer(registerDto);
        return " Register Done Succsessfully";
    }
    
}
