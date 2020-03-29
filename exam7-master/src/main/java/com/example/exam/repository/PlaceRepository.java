package com.example.exam.repository;

import com.example.exam.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<Place, String> {
}
