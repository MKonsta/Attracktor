package com.example.hw50.controller;


import com.example.hw50.model.User;
import com.example.hw50.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public User getAllUsers() {
//        return userService.getAll();
//        userService.getAll();
        return new User("Ivan", "email@mail.ru", "123");
    }
}
