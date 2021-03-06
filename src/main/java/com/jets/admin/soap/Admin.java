package com.jets.admin.soap;



import com.jets.admin.dtos.AdminGetResponse;
import com.jets.admin.dtos.AdminPutRequest;
import com.jets.admin.dtos.Admins;

import jakarta.jws.WebService;
@WebService
public interface Admin {
    public AdminGetResponse getAdminProfile(int id,String adminUuid);
    public AdminGetResponse updateAdmin(int id ,AdminPutRequest updateAdmin,String adminUuid);
    public Admins getAllAdmins(String adminUuid);

}
