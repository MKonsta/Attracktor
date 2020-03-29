package com.example.exam.repository;

import com.example.exam.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findAllByPersonEmail(String email);
}
