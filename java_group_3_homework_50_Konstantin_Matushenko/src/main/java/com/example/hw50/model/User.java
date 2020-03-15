package com.example.hw50.model;

import com.example.hw50.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
public class User {

    @Id
    private String id;
    @Indexed
    private String name;
    @Indexed
    private String email;
    private String password;
    @DBRef
    private List<User> subsciptions; //подписки
    @DBRef
    private List<User> subscibers; //подписчики

    @Autowired
    PublicationRepository publicationRepository;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscibers = new ArrayList<>();
        this.subsciptions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getSubsciptions() {
        return subsciptions;
    }

    public void setSubsciptions(List<User> subsciptions) {
        this.subsciptions = subsciptions;
    }

    public List<User> getSubscibers() {
        return subscibers;
    }

    public void setSubscibers(List<User> subscibers) {
        this.subscibers = subscibers;
    }
}
