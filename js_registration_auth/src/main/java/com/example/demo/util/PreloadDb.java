package com.example.demo.util;

import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PreloadDb {

    private final PersonRepo personRepo;

    public PreloadDb(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Bean
    void initDb() {
        personRepo.deleteAll();

        personRepo.save(new Person("kos@gmail.ru", "Konstantin", "kos", "123"));
    }
}
