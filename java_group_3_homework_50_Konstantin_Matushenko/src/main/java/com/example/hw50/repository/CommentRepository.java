package com.example.hw50.repository;

import com.example.hw50.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, String> {

    //Основные методы реализованы
}
