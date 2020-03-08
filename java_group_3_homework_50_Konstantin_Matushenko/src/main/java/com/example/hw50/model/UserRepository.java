package com.example.hw50.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    public User findUserByName(String name);

}
