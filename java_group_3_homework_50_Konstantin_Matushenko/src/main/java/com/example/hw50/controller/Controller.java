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
public class Controller {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @PostMapping(value = "",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addUser(@RequestBody User user) {
        System.out.println("++++++++++++++++++++++1111111111++++++++++++++++++++");
        userService.addNewUser(user.getName(), user.getEmail(), user.getPassword());
        return "fff";
    }


}
