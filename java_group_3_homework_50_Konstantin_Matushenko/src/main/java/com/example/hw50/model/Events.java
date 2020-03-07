package com.example.hw50.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Events {

    //Подписки. События - кто и на кого подписался;

    @Id
    private String id;
    private String publisherUserId; //id юзера на которого совершена подписка
    private String subscriberUserId; //id юзера который подписался
    private LocalDateTime date;

    public Events(String publisherUserId, String subscriberUserId, LocalDateTime date) {
        this.publisherUserId = publisherUserId;
        this.subscriberUserId = subscriberUserId;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisherUserId() {
        return publisherUserId;
    }

    public void setPublisherUserId(String publisherUserId) {
        this.publisherUserId = publisherUserId;
    }

    public String getSubscriberUserId() {
        return subscriberUserId;
    }

    public void setSubscriberUserId(String subscriberUserId) {
        this.subscriberUserId = subscriberUserId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
