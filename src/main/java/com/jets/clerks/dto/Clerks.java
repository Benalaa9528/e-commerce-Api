package com.jets.clerks.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Clerks {
    
    List<ClerkDto> clerks=new ArrayList<>();

    public List<ClerkDto> getClerks() {
        return clerks;
    }

    public void setClerks(List<ClerkDto> clerks) {
        this.clerks = clerks;
    }
    
}
