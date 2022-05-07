package com.jets.register.soap;

import com.jets.register.dto.RegisterDto;

import jakarta.jws.WebService;
@WebService
public interface Register {
    public String register(RegisterDto registerDto);
}
