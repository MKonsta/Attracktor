package com.example.hw50.controller;

import com.example.hw50.model.Publication;
import com.example.hw50.model.User;
import com.example.hw50.service.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/add")
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

    @DeleteMapping(path = "/del/{id}")
    public Publication deletePublication(@PathVariable String id, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return pubService.delete(id, user);
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

//    @GetMapping
//    public List<SubscriptionDTO>findSubscriptions(Authentication authentication, @ApiIgnore Pageable pageable) {
//        User user = (User) authentication.getPrincipal();
//        return subscriptionService.findByEmail(user.getUsername(), pageable);
//    }


}
