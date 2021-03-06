package com.example.hw50.repository;

import com.example.hw50.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends MongoRepository<Like, String> {

    boolean existsByUserID(String userId);

    List<Like> findAllByUserID(String userId);
}
