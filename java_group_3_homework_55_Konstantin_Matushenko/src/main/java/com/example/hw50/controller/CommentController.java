package com.example.hw50.controller;

import com.example.hw50.model.Comment;
import com.example.hw50.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAll();
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @DeleteMapping("/{commentId}")
    public Comment deleteComment(@PathVariable String commentId) {
        if (commentService.existsById(commentId)) {
            Comment comment = commentService.getById(commentId);
            commentService.deleteById(commentId);
            return comment;
        }
        return null;
    }

    @GetMapping("/get/{commentId}")
    public Comment getById(@PathVariable String commentId) {
        return commentService.getById(commentId);
    }

    @GetMapping("/user/{userId}")
    public List<Comment> getAllByUserId(@PathVariable String userId) {
        return commentService.findAllByUserId(userId);
    }

    @GetMapping("/user/{publicationId}")
    public List<Comment> getAllByPublicationId(@PathVariable String publicationId) {
        return commentService.findAllByPublicationId(publicationId);
    }
}
