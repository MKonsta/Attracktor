package com.example.hw50.repository;

import com.example.hw50.model.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublicationRepository extends MongoRepository<Publication, String> {

    //Поиск по тексту публикации
    Publication findByDiscription(String discription);

    List<Publication> findAllByUserId (String userId);
}
