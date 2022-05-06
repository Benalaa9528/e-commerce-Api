package com.jets.logout.rest;

import com.jets.logout.dao.LogOutDao;
import com.jets.logout.service.LogOutService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("logout")
public class LogOutController {
    @GET
    public Response logOut(@HeaderParam("LoginId") String uuid){
        LogOutService logOutService=new LogOutService(new LogOutDao());
       Boolean isLoggedOut= logOutService.logOut(uuid);
       System.out.println(isLoggedOut);
       if(isLoggedOut){
           return Response.ok().entity("Logged Out Successfully").build();
       }
       return Response.ok().entity("Logged Out Failed").build();
    }
}
