package com.example.hw50.util;

import com.example.hw50.model.*;
import com.example.hw50.repository.*;
import com.example.hw50.service.UserServiceImpl;
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


    public PreloadDataBasewithData(UserRepository userRepository,
                                   PublicationRepository publicationRepository,
                                   CommentRepository commentRepository,
                                   LikeRepository likeRepository,
                                   EventRepository eventRepository,
                                   UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
        this.eventRepository = eventRepository;
        this.userService = userService;
    }

    @Bean
    CommandLineRunner initDatabase() {

        userRepository.deleteAll();
        publicationRepository.deleteAll();
        commentRepository.deleteAll();
        likeRepository.deleteAll();
        eventRepository.deleteAll();

        userRepository.saveAll(createUsers());

        publicationRepository.save(new Publication("img0", "text0", LocalDateTime.now(), userRepository.findUserByName("Fedor").getId()));
        publicationRepository.save(new Publication("img1", "text1", LocalDateTime.now(), userRepository.findUserByName("Ivan").getId()));
        publicationRepository.save(new Publication("img2", "text2", LocalDateTime.now(), userRepository.findUserByName("Grisha").getId()));


        userService.addComment("new Comment1", publicationRepository.findByDiscription("text0").getId(), userService.getUserByEmail("ivan@mail.ru").getId());
        userService.addComment("new Comment2", publicationRepository.findByDiscription("text1").getId(), userService.getUserByEmail("ivan@mail.ru").getId());

        likeRepository.save(new Like(userRepository.findUserByName("Fedor").getId(), publicationRepository.findByDiscription("text0").getId(), LocalDateTime.now()));
        likeRepository.save(new Like(userRepository.findUserByName("Ivan").getId(), publicationRepository.findByDiscription("text1").getId(), LocalDateTime.now()));
        likeRepository.save(new Like(userRepository.findUserByName("Grisha").getId(), publicationRepository.findByDiscription("text0").getId(), LocalDateTime.now()));

        eventRepository.save(new Event(userRepository.findUserByName("Ivan").getId(), userRepository.findUserByName("Fedor").getId(), LocalDateTime.now()));
        eventRepository.save(new Event(userRepository.findUserByName("Fedor").getId(), userRepository.findUserByName("Ivan").getId(), LocalDateTime.now()));
        eventRepository.save(new Event(userRepository.findUserByName("Grisha").getId(), userRepository.findUserByName("Fedor").getId(), LocalDateTime.now()));

        userService.subscribe("fed@mail.ru", "ivan@mail.ru");

        return null;
    }

    private List<User> createUsers() {

        List<User> result = new ArrayList<>();

        result.add(new User("Fedor", "fed@mail.ru", "123"));
        result.add(new User("Ivan", "ivan@mail.ru", "123"));
        result.add(new User("Grisha", "stepan@mail.ru", "123"));

        return result;
    }
}
