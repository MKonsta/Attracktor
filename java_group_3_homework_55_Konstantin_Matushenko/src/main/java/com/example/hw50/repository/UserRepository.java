package com.example.hw50.repository;

import com.example.hw50.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends MongoRepository<User, String> {

    //Поиск юзера по имени
    User findUserByName(String name);

    User findUserByEmail(String email);

    User findUserById(String id);

    boolean existsByEmail(String email);

    void deleteByEmail(String email);


}
