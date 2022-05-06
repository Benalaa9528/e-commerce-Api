package com.jets.clerks.soap;



import com.jets.clerks.dto.ClerkDto;
import com.jets.clerks.dto.ClerkPostDto;
import com.jets.clerks.dto.Clerks;

import jakarta.jws.WebService;

@WebService
public interface Clerk{

    public Clerks getAllClerks();
    public ClerkDto getClerkById(int id);
    public String addClerk(ClerkPostDto clerk);
    public String deleteClerkById(int id);
    public String updateClerk(int id,ClerkPostDto clerkPostDto);

    
}