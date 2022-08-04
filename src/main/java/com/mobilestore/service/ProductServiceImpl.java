package com.mobilestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilestore.entities.Product;
import com.mobilestore.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    public Product getProductByCode(int code) {
        return repository.findById(code).orElse(null);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public void updateProducts(List<Product> products) {
        repository.saveAll(products);
    }
}
