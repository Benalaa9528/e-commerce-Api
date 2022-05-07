package com.jets.admin.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.jets.admin.dtos.AdminGetResponse;
import com.jets.admin.dtos.AdminPutRequest;
import com.jets.entity.Employees;
import com.jets.factory.EntityManagerProvider;
import com.jets.mappers.Mapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AdminDao{
	EntityManagerProvider provider=EntityManagerProvider.getInstance();
    EntityManager em=provider.getEntityManager(); 
	public AdminGetResponse getAdminInfo(int id){
		var admin=em.find(Employees.class, id);
		AdminGetResponse response=new AdminGetResponse();
		response.setName(admin.getName());
		response.setId(admin.getId());
		response.setDateOfBirth(admin.getBirthdate());
		return response;
	}
	public AdminGetResponse updateAdminInfo(int id,AdminPutRequest updatedAdmin){
		Employees admin=em.find(Employees.class, id);
		if(admin != null){
		admin.setName(updatedAdmin.getName());
		admin.setBirthdate(updatedAdmin.getDateOfBirth());
		beginTransaction();
		em.merge(admin);
		commit();
		return new AdminGetResponse(admin.getId(),admin.getName(),admin.getBirthdate());
		}
		return null;
	}
	public List<AdminGetResponse> getAllAdmins(){
		TypedQuery<Employees> query=em.createQuery("select e from Employees e where e.role = admin", Employees.class);
		var admins=query.getResultList();

		return admins.stream().map(Mapper::convertAdminEntityToAdminDto).collect(Collectors.toList());
	}
	public void beginTransaction() {
        em.getTransaction().begin();
    }
 
    
    public void commit() {
        em.getTransaction().commit();
    }
}