package com.example.hw50.service;

import com.example.hw50.model.Comment;
import com.example.hw50.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment comment) {
        comment.setDate(LocalDateTime.now());
        commentRepository.save(comment);
        return comment;
    }

    public void deleteAll() {
        commentRepository.deleteAll();
    }
}
