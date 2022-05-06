package com.jets.clerks.soap;

import java.util.List;

import com.jets.clerks.dto.ClerkDto;
import com.jets.clerks.dto.ClerkPostDto;


public interface Clerk{

    public List<ClerkDto> getAllClerks();
    public ClerkDto getClerkById(int id);
    public String addClerk(ClerkPostDto clerk);
    public String deleteClerkById(int id);
    public String updateClerk(int id,ClerkPostDto clerkPostDto);

    
}