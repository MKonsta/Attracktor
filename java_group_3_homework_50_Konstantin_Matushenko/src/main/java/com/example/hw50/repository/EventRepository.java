package com.example.hw50.repository;

import com.example.hw50.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, String> {

    //Можно реализовать пару методов поиска по ИД юзера, если понадобится
}
