package com.example.hw50.model;

import com.example.hw50.repository.PublicationRepository;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "users")
@ToString
public class User {

    @Id
    private String id;
    @Indexed
    private String name;
    @Indexed
    private String email;
    private String password;
    private List<String> subsciptions; //подписки
    private List<String> subscibers; //подписчики

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

    public List<String> getSubsciptions() {
        return subsciptions;
    }

    public void setSubsciptions(List<String> subsciptions) {
        this.subsciptions = subsciptions;
    }

    public List<String> getSubscibers() {
        return subscibers;
    }

    public void setSubscibers(List<String> subscibers) {
        this.subscibers = subscibers;
    }
}
