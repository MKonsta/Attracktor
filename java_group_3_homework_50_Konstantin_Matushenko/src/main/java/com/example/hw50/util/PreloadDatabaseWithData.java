package com.example.hw50.util;

import com.example.hw50.model.User;
import com.example.hw50.model.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class PreloadDatabaseWithData {

//    @Bean
//    CommandLineRunner initDatabase(UserRepository repository) {
//
//        repository.deleteAll();
//
//        return (args) -> Stream.of(users())
//                .peek(System.out::println)
//                .forEach(repository::save);
//    }

    @Bean
    int initDatabase(UserRepository repository) {

        repository.deleteAll();

        for (User user :  users()) {
            System.out.println(user);
            repository.save(user);
        }
        return 5;
    }

//    private User[] users() {
//
//        return new User[] {
//                new User("Ivan", "ivan@mail.ru", "123"),
//                new User("Fedor", "fedor@mail.ru", "123"),
//                new User("Anton", "anton@mail.ru", "123")
//        };
//    }

    private List<User> users() {
        List<User> result = new ArrayList<>();

        result.add(new User("Ivan", "ivan@mail.ru", "123"));
        result.add(new User("Fedor", "fedor@mail.ru", "123"));
        result.add(new User("Anton", "anton@mail.ru", "123"));

        return result;
    }


}
