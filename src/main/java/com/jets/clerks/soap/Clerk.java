package com.jets.clerks.soap;



import com.jets.clerks.dto.ClerkDto;
import com.jets.clerks.dto.ClerkPostDto;
import com.jets.clerks.dto.Clerks;

import jakarta.jws.WebService;

@WebService
public interface Clerk{

    public Clerks getAllClerks(String adminUuid);
    public ClerkDto getClerkById(int id,String adminUuid);
    public String addClerk(ClerkPostDto clerk,String adminUuid);
    public String deleteClerkById(int id,String adminUuid);
    public String updateClerk(int id,ClerkPostDto clerkPostDto,String adminUuid);

    
}