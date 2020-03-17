package com.example.hw50.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "comments")
@CompoundIndex(def = "{'date':1, 'userId':1}")
public class Comment {

    @Id
    private String id;
    private String content;
    private String publicationId;
    private LocalDateTime date;
    private String userId;

    public Comment(String content, LocalDateTime date, String userId, String publicationId) {
        this.content = content;
        this.date = date;
        this.userId = userId;
        this.publicationId = publicationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
