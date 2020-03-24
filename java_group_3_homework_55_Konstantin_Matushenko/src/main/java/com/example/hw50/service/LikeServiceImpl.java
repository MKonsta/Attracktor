package com.example.hw50.service;

import com.example.hw50.model.Like;
import com.example.hw50.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl {

    private final LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public Like addLike(Like like) {
        return likeRepository.save(like);
    }

    public void deleteAll() {
        likeRepository.deleteAll();
    }

    public List<Like> findAll() {
        return likeRepository.findAll();
    }

    public boolean existsById(String likeId) {
        return likeRepository.existsById(likeId);
    }

    public Like getLikeById(String likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public void deleteById(String likeId) {
        likeRepository.deleteById(likeId);
    }
}
