package com.example.hw50.controller;

import com.example.hw50.model.Publication;
import com.example.hw50.service.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Publication addPublication(@RequestBody Publication publication) {
        return pubService.addPublication(publication);
    }
//    {
//        "img" : "imageLink",
//            "discription" : "goodPub",
//            "userId" : "gfhgfyjtjrjrjytrt"
//    }

    @GetMapping("/{id}")
    public Publication getById(@PathVariable String id) {
        return pubService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Publication deletePublication(@PathVariable String id) {
        return pubService.delete(id);
    }

    //Лента юзера на основе его подписок
    @GetMapping("/lenta/{userId}")
    public List<Publication> getLentaForUser(@PathVariable String userId) {
        return pubService.getLentaOfPubForUser(userId);
    }

    @GetMapping("/all/{userId}")
    public List<Publication> getPublicationsOfUser(@PathVariable String userId) {
        return pubService.getAllByUserId(userId);
    }

}
