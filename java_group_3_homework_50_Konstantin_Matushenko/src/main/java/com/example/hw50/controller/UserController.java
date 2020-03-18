package com.example.hw50.controller;


import com.example.hw50.model.User;
import com.example.hw50.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user) {
        userService.addNewUser(user);
        if (user.getId() == null) {
            return null;
        } else {
            return user;
        }
    }
//    {
//        "name" : "Abram",
//        "email" : "abram@mail.ru",
//        "password" : "123"
//    }

    @DeleteMapping("/{email}")
    public User deleteUser(@PathVariable String email) {
        return userService.delete(email);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }




}
