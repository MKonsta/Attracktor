package com.example.hw50.repository;

import com.example.hw50.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    //Поиск юзера по имени
    public User findUserByName(String name);

}
