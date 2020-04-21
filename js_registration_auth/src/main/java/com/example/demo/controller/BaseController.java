package com.example.demo.controller;

import com.example.demo.SecurityConfig;
import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


}
