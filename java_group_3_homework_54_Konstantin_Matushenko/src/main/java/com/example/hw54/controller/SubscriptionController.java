package com.example.hw54.controller;

import com.example.hw54.dto.ResponseDTO;
import com.example.hw54.dto.SubscribeDTO;
import com.example.hw54.model.Event;
import com.example.hw54.model.Subscription;
import com.example.hw54.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subs")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseDTO makeSubscribe(@RequestBody SubscribeDTO subscribeDTO) {
        return subscriptionService.addSubscribe(subscribeDTO);
    }

    @GetMapping
    public List<Subscription> getAllSubs() {
        return subscriptionService.getAllSubs();
    }

    @GetMapping("/user/{email}")
    public List<Subscription> getAllSubsByUserEmail(@PathVariable String email) {
        return subscriptionService.getAllSubsByUserEmail(email);
    }

    @PostMapping("/cancel")
    public Event cancelSubscribe(@RequestBody SubscribeDTO subscribeDTO) {
        return subscriptionService.cancelSubscribe(subscribeDTO);
    }
}
