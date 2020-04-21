package com.example.demo.util;

import com.example.demo.SecurityConfig;
import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PreloadDb {

    private final PersonRepo personRepo;
    @Autowired
    SecurityConfig securityConfig;

    public PreloadDb(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Bean
    void initDb() {
        personRepo.deleteAll();

        personRepo.save(new Person("kos@gmail.ru", "Konstantin",
                "kos", securityConfig.encoder().encode("123")));
    }
}
