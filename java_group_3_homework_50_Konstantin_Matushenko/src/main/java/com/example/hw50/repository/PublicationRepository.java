package com.example.hw50.repository;

import com.example.hw50.model.Publication;
import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository<Publication, String> {

    //Поиск по тексту публикации
    public Publication findByDiscription(String discription);
}
