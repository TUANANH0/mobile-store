package com.mobilestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilestore.entities.Order;
import com.mobilestore.repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository repository;

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Order getNewestOrder() {
        List<Order> list = repository.findAll();
        return list.get(list.size()-1);
    }
}
