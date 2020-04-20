package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/registration")
    public Person createPerson(@RequestParam("email") String email,
                               @RequestParam("name") String name,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password) {

        Person person = new Person(email, name, login, password);
        personRepo.save(person);
        return person;
    }



}
