package com.example.demo.controller;

import com.example.demo.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private FoodRepository foodRepository;

    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("foodTypes", foodRepository.findAll());
        return "index";
    }
}
