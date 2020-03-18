package com.example.hw50.controller;

import com.example.hw50.model.Publication;
import com.example.hw50.repository.PublicationRepository;
import com.example.hw50.service.PublicationServiceImpl;
import com.example.hw50.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pub")
public class PublicationController {

//    @Autowired
//    private UserServiceImpl userService;
    @Autowired
    private PublicationServiceImpl pubService;

    @GetMapping
    public List<Publication> getAllPubs() {
        return pubService.getAll();
    }

    public String addPublication(@RequestBody Publication publication) {
        pubService.sa
    }

}
