package com.example.hw50.util;

import com.example.hw50.model.*;
import com.example.hw50.repository.*;
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


    public PreloadDataBasewithData(UserRepository userRepository,
                                   PublicationRepository publicationRepository,
                                   CommentRepository commentRepository,
                                   LikeRepository likeRepository,
                                   EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
        this.eventRepository = eventRepository;
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

        commentRepository.save(new Comment("Comment1", LocalDateTime.now(), userRepository.findUserByName("Fedor").getId()));
        commentRepository.save(new Comment("Comment2", LocalDateTime.now(), userRepository.findUserByName("Ivan").getId()));
        commentRepository.save(new Comment("Comment3", LocalDateTime.now(), userRepository.findUserByName("Grisha").getId()));

        likeRepository.save(new Like(userRepository.findUserByName("Fedor").getId(), publicationRepository.findByDiscription("text0").getId(), LocalDateTime.now()));
        likeRepository.save(new Like(userRepository.findUserByName("Ivan").getId(), publicationRepository.findByDiscription("text1").getId(), LocalDateTime.now()));
        likeRepository.save(new Like(userRepository.findUserByName("Grisha").getId(), publicationRepository.findByDiscription("text0").getId(), LocalDateTime.now()));

        eventRepository.save(new Event(userRepository.findUserByName("Ivan").getId(), userRepository.findUserByName("Fedor").getId(), LocalDateTime.now()));
        eventRepository.save(new Event(userRepository.findUserByName("Fedor").getId(), userRepository.findUserByName("Ivan").getId(), LocalDateTime.now()));
        eventRepository.save(new Event(userRepository.findUserByName("Grisha").getId(), userRepository.findUserByName("Fedor").getId(), LocalDateTime.now()));

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
