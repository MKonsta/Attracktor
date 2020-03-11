package com.example.hw50.repository;

import com.example.hw50.model.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, String> {

    //Можно реализовать пару методов поиска
}
