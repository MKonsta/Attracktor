package com.example.exam.repository;

import com.example.exam.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

    public boolean existsByEmail(String email);

    public void deleteByEmail(String email);

    public Person findByEmail(String email);
}
