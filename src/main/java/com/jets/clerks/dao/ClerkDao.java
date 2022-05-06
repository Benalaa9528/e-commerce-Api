package com.jets.clerks.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import com.jets.clerks.dto.ClerkDto;
import com.jets.clerks.dto.ClerkPostDto;
import com.jets.entity.Employees;
import com.jets.factory.EntityManagerProvider;
import com.jets.mappers.Mapper;

public class ClerkDao {
    EntityManagerProvider provider = EntityManagerProvider.getInstance();
    EntityManager em = provider.getEntityManager();

    public List<ClerkDto> getAllClerks() {
        TypedQuery<Employees> query = em.createQuery("select e from Employees e where e.role = :role", Employees.class);
        query.setParameter("role", "clerk");
        var clerks = query.getResultList();
        return clerks.stream().map(Mapper::convertEmployeeEntityToClerkDto).collect(Collectors.toList());
    }

    public ClerkDto getClerkById(int id) {
        Employees clerk = em.find(Employees.class, id);
        if (clerk.getRole().equalsIgnoreCase("clerk")) {
            return new ClerkDto(clerk.getId(), clerk.getName(), clerk.getEmail(), clerk.getRole());
        }
        throw new NotFoundException("clerk not found");

    }

    public void addClerk(ClerkPostDto clerkDto) {
        if (clerkDto.getRole().equalsIgnoreCase("clerk")) {
            Employees clerk = new Employees();
            // clerk.setId(clerkDto.getId());
            clerk.setEmail(clerkDto.getEmail());
            clerk.setName(clerkDto.getName());
            clerk.setPassword(clerkDto.getPassword());
            clerk.setRole(clerkDto.getRole());
            beginTransaction();
            em.persist(clerk);
            commit();

        }
    }

    public void updateClerk(int id,ClerkPostDto clerkDto) {
        if (clerkDto.getRole().equalsIgnoreCase("clerk")) {
            
           var clerk=  em.find(Employees.class, id);
          
            clerk.setEmail(clerkDto.getEmail());
            clerk.setName(clerkDto.getName());
            clerk.setPassword(clerkDto.getPassword());
            clerk.setRole(clerkDto.getRole());
            beginTransaction();
            em.merge(clerk);
            commit();

        }
    }

    public Boolean deleteClerkById(int id) {
        Employees clerk = em.find(Employees.class, id);
        if (clerk != null) {
            beginTransaction();
            em.remove(clerk);
            commit();
            return true;
        }
        return false;
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
}
