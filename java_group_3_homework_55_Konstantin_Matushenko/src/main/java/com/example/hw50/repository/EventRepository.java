package com.example.hw50.repository;

import com.example.hw50.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends MongoRepository<Event, String> {

    public void deleteById(String id);

    public boolean existsById(String id);
}
