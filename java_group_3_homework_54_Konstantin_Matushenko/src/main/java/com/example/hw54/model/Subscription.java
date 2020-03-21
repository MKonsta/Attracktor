package com.example.hw54.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "subscriptions")
@NoArgsConstructor
public class Subscription {

    @Id
    private String id;
    private String eventId;
    private String emailOfUsers;
    private LocalDateTime registrationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEmailOfUsers() {
        return emailOfUsers;
    }

    public void setEmailOfUsers(String emailOfUsers) {
        this.emailOfUsers = emailOfUsers;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
