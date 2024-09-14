package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.entity.Order;

@Service
public interface OrderService {
    
    public List<Order> getAllOrders();

    public Order createOrder(Order order);
}
