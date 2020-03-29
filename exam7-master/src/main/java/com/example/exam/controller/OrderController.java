package com.example.exam.controller;

import com.example.exam.model.Order;
import com.example.exam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order addNew(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping(path = "/del/{orderId}")
    public Order deleteById(@PathVariable String orderId) {
        return orderService.deleteById(orderId);
    }

    @GetMapping(path = "/get/{orderId}")
    public Order findById(@PathVariable String orderId) {
        return orderService.findById(orderId);
    }

    @GetMapping(path = "/findall")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping(path = "/findallbyperson/{personEmail}")
    public List<Order> findAllByUserEmail(@PathVariable String personEmail) {
        return orderService.findAllByPersonEmail(personEmail);
    }
}
