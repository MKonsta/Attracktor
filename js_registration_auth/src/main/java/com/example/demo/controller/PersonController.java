package com.example.demo.controller;

import com.example.demo.SecurityConfig;
import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    SecurityConfig securityConfig;

    @Autowired
    PersonRepo personRepo;

    @PostMapping("/registration")
    public Person createPerson(@RequestParam("email") String email,
                               @RequestParam("name") String name,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password) {

        Person person = new Person(email, name, login, password);
        personRepo.save(new Person(email, name, login, securityConfig.encoder().encode(password)));
        return person;
    }

    @PostMapping("login")
    public Person makeLogin(@RequestParam("login") String login, @RequestParam("password") String password) {
        Person person = personRepo.findByLogin(login);
        return person;
    }


}
