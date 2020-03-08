package com.example.hw50.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    //Поиск юзера по имени
    public User findUserByName(String name);

}