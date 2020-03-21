package com.example.hw54.repository;

import com.example.hw54.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    @Override
    boolean existsById(String s);
}
