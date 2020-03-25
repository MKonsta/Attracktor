package com.example.hw50.util;

import com.example.hw50.SecurityConfig;
import com.example.hw50.model.*;
import com.example.hw50.repository.*;
import com.example.hw50.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class PreloadDataBasewithData {

    private final UserServiceImpl userService;
    private final PublicationServiceImpl publicationService;
    private final CommentServiceImpl commentService;
    private final LikeServiceImpl likeService;
    private final EventServiceImpl eventService;


    public PreloadDataBasewithData(UserServiceImpl userService,
                                   PublicationServiceImpl publicationService,
                                   CommentServiceImpl commentService,
                                   LikeServiceImpl likeService,
                                   EventServiceImpl eventService) {

        this.userService = userService;
        this.publicationService = publicationService;
        this.commentService = commentService;
        this.likeService = likeService;
        this.eventService = eventService;
    }

    @Bean
    CommandLineRunner initDatabase() {

        userService.deleteAll();
        publicationService.deleteAll();
        commentService.deleteAll();
        likeService.deleteAll();
        eventService.deleteAll();

        userService.addAllUsers(createUsers());

        Publication publication = new Publication();
        publication.setImg("img0");
        publication.setDiscription("disriptfewfqfwec");
        publication.setDate(LocalDateTime.now());
        publication.setUserId(userService.getUserByEmail("fed@mail.ru").getId());
        publicationService.addPublication(publication);

        publication = new Publication();
        publication.setImg("img1");
        publication.setDiscription("disrrrgwewgiptfewfqfwec");
        publication.setDate(LocalDateTime.now());
        publication.setUserId(userService.getUserByEmail("ivan@mail.ru").getId());
        publicationService.addPublication(publication);

        publication = new Publication();
        publication.setImg("img2");
        publication.setDiscription("disrrrgwewgiptfewfqfwec");
        publication.setDate(LocalDateTime.now());
        publication.setUserId(userService.getUserByEmail("grisha@mail.ru").getId());
        publicationService.addPublication(publication);


        Comment comment = new Comment();
        comment.setContent("WCeceafcdkdkrgerghrtsdssdsa");
        comment.setUserId(userService.getUserByEmail("fed@mail.ru").getId());
        commentService.addComment(comment);

        comment = new Comment();
        comment.setContent("WCeceafcfhdfdgtjuldkdkrgerghrtsdssdsa");
        comment.setUserId(userService.getUserByEmail("ivan@mail.ru").getId());
        commentService.addComment(comment);

        comment = new Comment();
        comment.setContent("WCeceafcfhdfdgtjuldkdkrge343jyukilurghrtsdssdsa");
        comment.setUserId(userService.getUserByEmail("grisha@mail.ru").getId());
        commentService.addComment(comment);


        Like like = new Like();
        like.setPublicationId("gergwwwwweqrw");
        like.setUserID(userService.getUserByEmail("ivan@mail.ru").getId());
        likeService.addLike(like);

        return null;
    }

    private List<User> createUsers() {

        List<User> result = new ArrayList<>();

        User user = new User();
        user.setName("Fedor");
        user.setEmail("fed@mail.ru");
        user.setPassword(new SecurityConfig().encoder().encode("123"));
        user.setSubscibers(new ArrayList<>());
        user.setSubsciptions(new ArrayList<>());
        result.add(user);

        user = new User();
        user.setName("Ivan");
        user.setEmail("ivan@mail.ru");
        user.setPassword(new SecurityConfig().encoder().encode("123"));
        user.setSubscibers(new ArrayList<>());
        user.setSubsciptions(new ArrayList<>());
        result.add(user);

        user = new User();
        user.setName("Grisha");
        user.setEmail("grisha@mail.ru");
        user.setPassword(new SecurityConfig().encoder().encode("123"));
        user.setSubscibers(new ArrayList<>());
        user.setSubsciptions(new ArrayList<>());
        result.add(user);

        return result;
    }
}
