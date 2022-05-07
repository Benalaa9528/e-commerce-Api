package com.jets.login.dao;

import com.jets.entity.Customers;
import com.jets.entity.Employees;
import com.jets.factory.EntityManagerProvider;

import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;

public class CheckerDao {
    EntityManagerProvider provider = EntityManagerProvider.getInstance();
    EntityManager em = provider.getEntityManager();

    public Boolean isCustomer(String email, String password) {

        TypedQuery<Customers> query = em.createQuery(
                "select c from Customers c where c.email=:email and c.password=:password",
                Customers.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void updateCustomer(Customers customer) {
        beginTransaction();
        em.merge(customer);
        commit();
    }

    public void updateEmployee(Employees employee) {
        beginTransaction();
        em.merge(employee);
        commit();
    }

    public Customers findCustomer(String email) {

        TypedQuery<Customers> query = em.createQuery("select c from Customers c where c.email=:email ",
                Customers.class);
        query.setParameter("email", email);

        Customers customer = query.getSingleResult();

        return customer;

    }

    public Employees findEmployee(String email) {

        TypedQuery<Employees> query = em.createQuery("select c from Employees c where c.email=:email ",
                Employees.class);
        query.setParameter("email", email);

        Employees employee = query.setMaxResults(1).getSingleResult();

        return employee;

    }

    public Customers getLoggedInCustomer(String uuid) {

        TypedQuery<Customers> query = em.createQuery("select c from Customers c where c.authtoken=:uuid",
                Customers.class);
        return query.setParameter("uuid", uuid).setMaxResults(1).getSingleResult();
    }

    public Employees getLoggedInEmployee(String uuid) {

        TypedQuery<Employees> query = em.createQuery("select E from Employees E where E.authtoken=:uuid",
                Employees.class);
        return query.setParameter("uuid", uuid).setMaxResults(1).getSingleResult();
    }

    public Boolean isEmployee(String email, String password) {
        TypedQuery<Employees> query = em.createQuery(
                "select e from Employees e where e.email=:email and e.password=:password", Employees.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        Employees employee = query.setMaxResults(1).getSingleResult();
        return employee != null;
    }
   public  Boolean findEmployeeById(int id){
       var emp=em.find(Employees.class, id);
       if(emp == null){
           return false;
       }
        return true;
    }
    public Employees getEmployeeById(int id){
        var emp=em.find(Employees.class, id);
        if(emp != null){
            return emp;
        }
        return null;
    }

    public  Customers findCustomerById(int id){
        var customer=em.find(Customers.class, id);
        if(customer != null){
            return customer;
        }
         return null;
     }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
}
