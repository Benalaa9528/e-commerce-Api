package com.jets.entity;
// Generated Apr 24, 2022, 1:52:59 AM by Hibernate Tools 6.0.0.Beta2


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name="orders"
    ,catalog="ecommerceapi"
)
public class Orders  implements java.io.Serializable {


     private int id;
     private Customers customers;
     private Date date;
     private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

    public Orders() {
    }

	
    public Orders( Customers customers, Date date) {
       
        this.customers = customers;
        this.date = date;
    }
    public Orders( Customers customers, Date date, Set<OrderDetails> orderDetailses) {
      
       this.customers = customers;
       this.date = date;
       this.orderDetailses = orderDetailses;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public Customers getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    
    @Column(name="date", nullable=false, length=100)
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="orders")
    public Set<OrderDetails> getOrderDetailses() {
        return this.orderDetailses;
    }
    
    public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
        this.orderDetailses = orderDetailses;
    }




}

