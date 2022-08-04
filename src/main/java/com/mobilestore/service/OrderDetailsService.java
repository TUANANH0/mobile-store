package com.mobilestore.service;

import java.util.List;

import com.mobilestore.entities.Order;
import com.mobilestore.entities.OrderDetail;
import com.mobilestore.entities.Product;

public interface OrderDetailsService {

    List<OrderDetail> createOrderDetails(Order order);

    boolean addToCart(Product product);

    boolean removeItemInCart(int productCode);

    boolean clearCart();

    List<OrderDetail> getCart();

    double getCartTotal();

    List<Product> upateProductsInStock();
}
