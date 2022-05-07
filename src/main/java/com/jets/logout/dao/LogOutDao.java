package com.jets.logout.dao;

import com.jets.factory.EntityManagerProvider;
import com.jets.login.dao.CheckerDao;

import jakarta.persistence.EntityManager;

public class LogOutDao {
    EntityManagerProvider provider = EntityManagerProvider.getInstance();
    EntityManager em = provider.getEntityManager();
    
    public Boolean logOut(String uuid) {
        CheckerDao checkerDao = new CheckerDao();
        var customer = checkerDao.getLoggedInCustomer(uuid);
        System.out.println(customer.getAuthtoken());

       
            System.out.println("inside if");
            customer.setAuthtoken(null);
            System.out.println("before update");
            System.out.println(customer.getAuthtoken());
          //  checkerDao.updateCustomer(customer);
            beginTransaction();
            em.merge(customer);
            commit();
            
            System.out.println("after update");
            return true;
        

    }
    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
}
