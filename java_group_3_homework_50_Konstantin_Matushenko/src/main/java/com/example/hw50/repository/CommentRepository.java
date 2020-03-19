package com.example.hw50.repository;

import com.example.hw50.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    @Override
    boolean existsById(String s);

    @Override
    void deleteById(String s);

    Comment getCommentById(String id);

    List<Comment> findAllByUserId(String userId);

    List<Comment> findAllByPublicationId(String publicationId);
}
