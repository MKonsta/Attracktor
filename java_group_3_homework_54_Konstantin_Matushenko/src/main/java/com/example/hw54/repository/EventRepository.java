package com.example.hw54.repository;

import com.example.hw54.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {

    @Override
    boolean existsById(String s);
}
