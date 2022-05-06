package com.jets.categories.daos;
import java.util.List;

import java.util.stream.Collectors;

import com.jets.categories.dtos.CategoryDto;
import com.jets.entity.Categories;
import com.jets.entity.Customers;
import com.jets.factory.EntityManagerProvider;
import com.jets.mappers.Mapper;
import com.jets.products.dto.ProductDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CategoryDao {
    EntityManagerProvider provider=EntityManagerProvider.getInstance();
    EntityManager em=provider.getEntityManager(); 

    public List<CategoryDto> getAllCategories(){
        var catList=em.createQuery("select c from Categories c ", Categories.class).getResultList();
        return catList.stream().map(Mapper::convertCategoryEntityToCategoryDto).collect(Collectors.toList());
    }
    public Customers getLoggedInCustomer(String uuid){
      
        TypedQuery<Customers> query= em.createQuery("select c from Customers c where c.authtoken=:uuid", Customers.class);
        return query.setParameter("uuid", uuid).setMaxResults(1).getSingleResult();
    }

    public CategoryDto getCategoryById(int id){
        Categories cat=em.find(Categories.class, id);
        return new CategoryDto(cat.getName(), cat.getDescription());
    }
    private Categories getCategoryEntityById(int id){
        Categories cat=em.find(Categories.class, id);
        return cat;
    }
public List<ProductDto> getCategoryProductsByCategoryId(int id){
    var cat=getCategoryEntityById(id);
    var products=cat.getProductses();
   return products.stream().map(Mapper::convertProductEntityToProductDto).collect(Collectors.toList());
}
    public List<ProductDto> getAllProductsByCategoryId(int id){
        return null;
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }
 
    
    public void commit() {
        em.getTransaction().commit();
    }
 
}
