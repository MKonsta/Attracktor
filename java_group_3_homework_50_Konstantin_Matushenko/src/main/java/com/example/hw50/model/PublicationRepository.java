package com.example.hw50.model;

import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository<Publication, String> {

    //Поиск по тексту публикации
    public Publication findByDiscription(String discription);
}
