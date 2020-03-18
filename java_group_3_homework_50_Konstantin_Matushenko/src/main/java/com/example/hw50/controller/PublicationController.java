package com.example.hw50.controller;

import com.example.hw50.model.Publication;
import com.example.hw50.service.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pub")
public class PublicationController {

    @Autowired
    private PublicationServiceImpl pubService;

    @GetMapping
    public List<Publication> getAllPubs() {
        return pubService.getAll();
    }

    @PostMapping(path = "/1")
    public String addPublication( Publication publication) {
        pubService.addPublication(publication);
        return "ok";
    }

}
