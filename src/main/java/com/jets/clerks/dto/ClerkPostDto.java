package com.jets.clerks.dto;

public class ClerkPostDto {
    




    private String name;
    private String email;
    private String role;
    private String password;
    
    
    public ClerkPostDto( String name, String email, String role, String password) {
        
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public ClerkPostDto() {
    }
    
 

   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
  
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
}


