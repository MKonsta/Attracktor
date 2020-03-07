package com.example.hw50.service;

import com.example.hw50.model.User;

import java.util.List;

public interface UserService {

    public User getUserById(String id);

    public User get(String id);

    public void save(User user);

    public void delete(String id);

    public List<User> getAll();
}
