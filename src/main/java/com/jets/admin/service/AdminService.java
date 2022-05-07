package com.jets.admin.service;

import java.util.List;

import com.jets.admin.dao.AdminDao;
import com.jets.admin.dtos.AdminGetResponse;
import com.jets.admin.dtos.AdminPutRequest;

public class AdminService {
    AdminDao adminDao;
    
    public AdminService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public AdminGetResponse getAdminInfo(int id){
       return adminDao.getAdminInfo(id);
    }
    public AdminGetResponse updateAdminInfo(int id,AdminPutRequest updatedAdmin){
        return adminDao.updateAdminInfo(id, updatedAdmin);
     }
     public List<AdminGetResponse> getAllAdmins(){
         AdminDao adminDao=new AdminDao();
       return  adminDao.getAllAdmins();
     }
}
