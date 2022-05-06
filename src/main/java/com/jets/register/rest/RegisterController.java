package com.jets.register.rest;

import com.jets.register.dao.RegisterDao;
import com.jets.register.dto.RegisterDto;
import com.jets.register.service.RegisterService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("register")
public class RegisterController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
   public Response register(RegisterDto registerDto){
       RegisterService service=new RegisterService(new RegisterDao());
       service.registerCustomer(registerDto);
       return Response.ok().entity("done").build();
   } 
    
}
