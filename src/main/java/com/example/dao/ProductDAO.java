package com.example.dao;

import com.example.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
//Data Access Object  like repository classes in springboot
@Transactional
public class ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;
 //add new entity

    public void create(Product product) {
        entityManager.persist(product);
    }

    public Product read(Long id) {
        return entityManager.find(Product.class, id);
    }
    public List<Product> readAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
// update

    public void update(Product product) {
        entityManager.merge(product);
    }

    public void delete(Long id) {
        Product product = read(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
