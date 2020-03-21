package com.example.hw54.service;

import com.example.hw54.dto.ResponseDTO;
import com.example.hw54.dto.SubscribeDTO;
import com.example.hw54.model.Event;
import com.example.hw54.model.Subscription;
import com.example.hw54.repository.EventRepository;
import com.example.hw54.repository.SubscriptionRepository;
import com.example.hw54.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionService {

    private EventRepository eventRepository;
    private UserRepository userRepository;
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(EventRepository eventRepository, UserRepository userRepository, SubscriptionRepository subscriptionRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public ResponseDTO addSubscribe(SubscribeDTO subscribeDTO) {

        //Валидация id юзера и id события
        if (eventRepository.existsById(subscribeDTO.getEventId()) && userRepository.existsById(subscribeDTO.getUserId())) {

            LocalDateTime eventDate = eventRepository.findById(subscribeDTO.getEventId()).get().getDate();

            //Валидация даты события
            if (eventDate.isAfter(LocalDateTime.now().plusDays(1))) {

                String userEmail = userRepository.findById(subscribeDTO.getUserId()).get().getEmail();

                //Проверка того, что юзер еще не подписан на это событие
                if (!subscriptionRepository.existsByEmailOfUsersAndEventId(userEmail, subscribeDTO.getEventId())) {

                    Subscription subscription = new Subscription();
                    subscription.setEventId(subscribeDTO.getEventId());
                    subscription.setRegistrationDate(LocalDateTime.now());
                    subscription.setEmailOfUsers(userRepository.findById(subscribeDTO.getUserId()).get().getEmail());
                    subscriptionRepository.save(subscription);

                    return new ResponseDTO(subscribeDTO.getEventId(), "You successfull subscribed on event!");

                } else {
                    return new ResponseDTO(subscribeDTO.getEventId(), "You already subscribe on this event");
                }

            } else {
                return new ResponseDTO(subscribeDTO.getEventId(), "Too late for subscribe on this event");
            }

        } else {
            return new ResponseDTO(subscribeDTO.getEventId(), "Wrong userId, or eventId");
        }
    }

    public List<Subscription> getAllSubsByUserEmail(String email) {
        return subscriptionRepository.findAllByEmailOfUsers(email);
    }

    public Event cancelSubscribe(SubscribeDTO subscribeDTO) {

        //Валидация id юзера и id события
        if (eventRepository.existsById(subscribeDTO.getEventId()) && userRepository.existsById(subscribeDTO.getUserId())) {
            Event event = eventRepository.findById(subscribeDTO.getEventId()).get();
            String userEmail = userRepository.findById(subscribeDTO.getUserId()).get().getEmail();
            subscriptionRepository.deleteByEmailOfUsersAndEventId(userEmail, subscribeDTO.getEventId());
            return event;
        }

        return null;
    }

    public List<Subscription> getAllSubs() {
        return subscriptionRepository.findAll();
    }
}
