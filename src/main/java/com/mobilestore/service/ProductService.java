package com.mobilestore.service;

import java.util.List;

import com.mobilestore.entities.Product;

public interface ProductService {

    Product getProductByCode(int code);

    List<Product> getProducts();

    Product addProduct(Product product);

    void updateProducts(List<Product> products);
}
