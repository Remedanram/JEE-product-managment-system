package com.example.service;

import com.example.dao.ProductDAO;
import com.example.entity.Product;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ProductService {

    @Inject
    private ProductDAO productDAO;

    public void createProduct(Product product) {
        productDAO.create(product);
    }

    public Product getProductById(Long id) {
        return productDAO.read(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.readAll();
    }

    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    public void deleteProduct(Long id) {
        productDAO.delete(id);
    }
}
