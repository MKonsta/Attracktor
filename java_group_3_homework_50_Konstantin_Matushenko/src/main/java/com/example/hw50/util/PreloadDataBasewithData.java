package com.example.hw50.util;

import com.example.hw50.model.Publication;
import com.example.hw50.model.PublicationRepository;
import com.example.hw50.model.User;
import com.example.hw50.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PreloadDataBasewithData {

    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;

    @Autowired
    public PreloadDataBasewithData(UserRepository userRepository, PublicationRepository publicationRepository) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;


    }

    @Bean
    private Object initDatabase() {
        userRepository.deleteAll();
        publicationRepository.deleteAll();

        userRepository.saveAll(createUsers());
        publicationRepository.saveAll(createPublications());

        return null;
    }

    private List<User> createUsers() {
        List<User> result = new ArrayList<>();

        result.add(new User("Fedor", "fed@mail.ru", "123"));
        result.add(new User("Ivan", "ivan@mail.ru", "123"));
        result.add(new User("Stepan", "stepan@mail.ru", "123"));

        return result;
    }

    private List<Publication> createPublications() {
        List<Publication> result = new ArrayList<>();

        result.add(new Publication("ffafewaqf", "weqgeger", LocalDateTime.now(), userRepository.findUserByName("Ivan").getId()));
        result.add(new Publication("l;yutjdrga", "gabsber", LocalDateTime.now(), userRepository.findUserByName("Fedor").getId()));
        result.add(new Publication("ytdsrteve6", "ngdbvga", LocalDateTime.now(), userRepository.findUserByName("Fedor").getId()));

        return result;
    }
}
