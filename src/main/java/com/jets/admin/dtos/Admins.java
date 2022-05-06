package com.jets.admin.dtos;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Admins {
    
    List<AdminGetResponse> admins=new ArrayList<>();

    public List<AdminGetResponse> getAdmins() {
        return admins;
    }

    public void setAdmins(List<AdminGetResponse> admins) {
        this.admins = admins;
    }
    
}
