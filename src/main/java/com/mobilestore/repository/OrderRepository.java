package com.mobilestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobilestore.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}