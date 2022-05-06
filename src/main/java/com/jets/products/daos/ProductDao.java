package com.jets.products.daos;


import java.util.List;

import java.util.stream.Collectors;

import com.jets.categories.dtos.CategoryDto;

import com.jets.entity.Products;

import com.jets.factory.EntityManagerProvider;
import com.jets.mappers.Mapper;
import com.jets.products.dto.ProductDto;
import com.jets.products.dto.ProductPostDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class ProductDao {
   
  EntityManagerProvider provider=EntityManagerProvider.getInstance();
  EntityManager em=provider.getEntityManager(); 
  
    public ProductDao() {
        
        
    }
    
 public List<ProductDto> getAllProducts(){
      
    var productList= em.createQuery("select p from Products p ", Products.class).getResultList();

        return productList.stream().map(Mapper::convertProductEntityToProductDto).collect(Collectors.toList());
    }
    
   public Products getProductById(int id){
      
     Products product=em.find(Products.class, id);
     em.refresh(product);
     return product;
   }


   public void addProduct(ProductPostDto productDto){
    Products product=new Products();
    product.setName(productDto.getName());
    product.setImage(productDto.getImage());
    product.setDescription(productDto.getDecription());
    product.setCategories(product.getCategories());
    product.setPrice(productDto.getPrice());
    product.setQuantity(productDto.getQuantity());
    beginTransaction();
    em.persist(product);
    commit();

   }
  public Products deleteProductById(int id){
    Products product=  em.find(Products.class, id);
    beginTransaction();
    em.remove(product);
    commit();
    return product;
       
       
   }
   
   public CategoryDto getProductCategory(int id){
     return null;

   }
   public void beginTransaction() {
       em.getTransaction().begin();
   }

   
   public void commit() {
       em.getTransaction().commit();
   }

   public List<ProductDto> searchProductsByPattern(String pattern){
    String qlString = "select p from Products p where p.name like :key";
    TypedQuery<Products> q = em.createQuery(qlString, Products.class);
    q.setParameter("key", '%'+pattern+'%');
     var list=q.getResultList();
     return list.stream().map(Mapper::convertProductEntityToProductDto).collect(Collectors.toList());
}
}
