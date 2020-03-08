package com.example.hw50.model;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, String> {

    //Основные методы реализованы
}
