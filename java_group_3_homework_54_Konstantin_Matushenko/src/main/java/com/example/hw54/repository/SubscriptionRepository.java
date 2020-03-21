package com.example.hw54.repository;

import com.example.hw54.model.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {

    boolean existsByEmailOfUsersAndEventId(String UserEmail, String eventId);

    List<Subscription> findAllByEmailOfUsers(String userEmail);

    void deleteByEmailOfUsersAndEventId(String userEmail, String eventId);
}
