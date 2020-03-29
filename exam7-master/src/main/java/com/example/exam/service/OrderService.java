package com.example.exam.service;

import com.example.exam.model.Order;
import com.example.exam.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order) {
        order.setDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }

    public Order deleteById(String orderId) {
        if (orderRepository.existsById(orderId)) {
            Order order = orderRepository.findById(orderId).orElse(null);
            orderRepository.deleteById(orderId);
            return order;
        }
        return null;
    }

    public Order findById(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findAllByPersonEmail(String userEmail) {
        return orderRepository.findAllByPersonEmail(userEmail);
    }

}
