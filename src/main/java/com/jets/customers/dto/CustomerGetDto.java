package com.jets.customers.dto;

public class CustomerGetDto {
    
    private int id;
    private String name;
    private String email;
    private String password;
    
    public CustomerGetDto() {
    }
    
 

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public CustomerGetDto(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}


