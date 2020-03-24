package com.example.hw50.service;

import com.example.hw50.model.Comment;
import com.example.hw50.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }

    public boolean existsById(String id) {
        return commentRepository.existsById(id);
    }

    public void deleteAll() {
        commentRepository.deleteAll();
    }

    public Comment getById(String id) {
        return commentRepository.getCommentById(id);
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findAllByUserId(String userId) {
        return commentRepository.findAllByUserId(userId);
    }

    public List<Comment> findAllByPublicationId(String userId) {
        return commentRepository.findAllByUserId(userId);
    }
}
