package com.example.hw50.util;

import com.example.hw50.model.User;
import com.example.hw50.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class PreloadDataBasewithData {

    private final UserRepository userRepository;

    @Autowired
    public PreloadDataBasewithData(UserRepository userRepository) {
        this.userRepository = userRepository;
        userRepository.deleteAll();
    }

    @Bean
    private Object initDatabase() {
        userRepository.saveAll(createUsers());

        return null;
    }

    private List<User> createUsers() {
        List<User> result = new ArrayList<>();

        result.add(new User("Fedor", "fed@mail.ru", "123"));
        result.add(new User("Ivan", "ivan@mail.ru", "123"));
        result.add(new User("Stepan", "stepan@mail.ru", "123"));

        return result;
    }
}
