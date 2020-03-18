package com.example.hw50.repository;

import com.example.hw50.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

    //Основные методы реализованы
}
