package com.example.hw50.controller;

import com.example.hw50.model.Like;
import com.example.hw50.model.User;
import com.example.hw50.service.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    private LikeServiceImpl likeService;

    @Autowired
    public LikeController(LikeServiceImpl likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAll() {
        return likeService.findAll();
    }

    @PostMapping(path = "/add")
    public Like addLike(@RequestBody Like like, Authentication authentication) {
        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            like.setUserID(user.getId());
        }
        return likeService.addLike(like);
    }

    @DeleteMapping
    public Like deleteLikeById(String likeId) {
        if (likeService.existsById(likeId)) {
            Like like = likeService.getLikeById(likeId);
            likeService.deleteById(likeId);
            return like;
        }
        return null;
    }
}
