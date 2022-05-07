package com.jets.logout.soap;

import jakarta.jws.WebService;

@WebService
public interface LogOut {
    public String logOut(String customerUuid);
}
