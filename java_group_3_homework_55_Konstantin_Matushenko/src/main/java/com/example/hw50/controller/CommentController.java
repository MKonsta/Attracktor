package com.example.hw50.controller;

import com.example.hw50.model.Comment;
import com.example.hw50.model.Publication;
import com.example.hw50.model.User;
import com.example.hw50.service.CommentServiceImpl;
import com.example.hw50.service.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private PublicationServiceImpl publicationService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAll();
    }

    @PostMapping(path = "/add")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @DeleteMapping("del/{commentId}")
    public Comment deleteComment(@PathVariable String commentId, Authentication authentication) {
        if (commentService.existsById(commentId) && authentication != null) {
            Comment comment = commentService.getById(commentId);
            User user = (User) authentication.getPrincipal();
            Publication publication = publicationService.getById(comment.getPublicationId());
            if (user.getId().equals(publication.getUserId())) {
                commentService.deleteById(commentId);
                return comment;
            }
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
