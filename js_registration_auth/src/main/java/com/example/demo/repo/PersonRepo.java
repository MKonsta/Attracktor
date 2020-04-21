package com.example.demo.repo;

import com.example.demo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PersonRepo extends MongoRepository<Person, String> {

    public Person findByLogin(String login);
}
