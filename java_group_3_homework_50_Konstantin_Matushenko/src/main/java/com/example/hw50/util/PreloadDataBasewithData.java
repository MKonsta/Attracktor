package com.example.hw50.util;

import com.example.hw50.model.*;
import com.example.hw50.repository.*;
import com.example.hw50.service.CommentServiceImpl;
import com.example.hw50.service.LikeServiceImpl;
import com.example.hw50.service.PublicationServiceImpl;
import com.example.hw50.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class PreloadDataBasewithData {

    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;
    private final EventRepository eventRepository;
    private final UserServiceImpl userService;
    private final PublicationServiceImpl publicationService;
    private final CommentServiceImpl commentService;
    private final LikeServiceImpl likeService;


    public PreloadDataBasewithData(UserRepository userRepository,
                                   PublicationRepository publicationRepository,
                                   CommentRepository commentRepository,
                                   LikeRepository likeRepository,
                                   EventRepository eventRepository,
                                   UserServiceImpl userService,
                                   PublicationServiceImpl publicationService,
                                   CommentServiceImpl commentService,
                                   LikeServiceImpl likeService) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
        this.eventRepository = eventRepository;
        this.userService = userService;
        this.publicationService = publicationService;
        this.commentService = commentService;
        this.likeService = likeService;
    }

    @Bean
    CommandLineRunner initDatabase() {

        userService.deleteAll();
        publicationService.deleteAll();
        commentService.deleteAll();
        likeService.deleteAll();
        eventRepository.deleteAll();

        userRepository.saveAll(createUsers());

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
        user.setPassword("123");
        user.setSubscibers(new ArrayList<>());
        user.setSubsciptions(new ArrayList<>());
        result.add(user);

        user = new User();
        user.setName("Ivan");
        user.setEmail("ivan@mail.ru");
        user.setPassword("123");
        user.setSubscibers(new ArrayList<>());
        user.setSubsciptions(new ArrayList<>());
        result.add(user);

        user = new User();
        user.setName("Grisha");
        user.setEmail("grisha@mail.ru");
        user.setPassword("123");
        user.setSubscibers(new ArrayList<>());
        user.setSubsciptions(new ArrayList<>());
        result.add(user);

        return result;
    }
}
