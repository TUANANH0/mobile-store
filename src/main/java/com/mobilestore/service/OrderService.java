package com.mobilestore.service;

import com.mobilestore.entities.Order;

public interface OrderService {
    Order createOrder(Order order);

    Order getNewestOrder();
}
