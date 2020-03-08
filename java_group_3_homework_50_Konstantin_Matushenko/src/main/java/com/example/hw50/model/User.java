package com.example.hw50.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private int publications;
    private int subsciptions; //подписки
    private int subscibers; //подписчики

    @Autowired
    PublicationRepository publicationRepository;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    public int getPublications() {
        return publications;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }

    public int getSubsciptions() {
        return subsciptions;
    }

    public void setSubsciptions(int subsciptions) {
        this.subsciptions = subsciptions;
    }

    public int getSubscibers() {
        return subscibers;
    }

    public void setSubscibers(int subscibers) {
        this.subscibers = subscibers;
    }

}
