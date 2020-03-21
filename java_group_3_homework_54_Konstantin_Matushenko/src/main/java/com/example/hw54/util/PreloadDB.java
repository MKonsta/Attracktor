package com.example.hw54.util;

import com.example.hw54.controller.EventController;
import com.example.hw54.model.Event;
import com.example.hw54.model.User;
import com.example.hw54.service.EventService;
import com.example.hw54.service.SubscriptionService;
import com.example.hw54.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class PreloadDB {

    private UserService userService;
    private EventService eventService;
    private SubscriptionService subscriptionService;

    @Autowired
    public PreloadDB(UserService userService, EventService eventService, SubscriptionService subscriptionService) {
        this.userService = userService;
        this.eventService = eventService;
        this.subscriptionService = subscriptionService;
    }

    @Bean
    public void initDB() {

        userService.addAll(createUsers());
        eventService.addAll(createEvents());
    }

    private List<User> createUsers() {

        List<User> result = new ArrayList<>();

        User user = new User();
        user.setName("Volodya");
        user.setEmail("voloha@mail.ru");
        result.add(user);

        user = new User();
        user.setName("Andrey");
        user.setEmail("andy@mail.ru");
        result.add(user);

        user = new User();
        user.setName("Semen");
        user.setEmail("sema@mail.ru");
        result.add(user);

        return result;
    }

    private List<Event> createEvents() {

        List<Event> result = new ArrayList<>();

        Event event = new Event();
        event.setName("Vistovka");
        event.setDescription("Vsemirnaya Vistovka koshek");
        event.setDate(LocalDateTime.of(2020, Month.MAY, 8, 13, 0));
        result.add(event);

        event = new Event();
        event.setName("Pohod v gori");
        event.setDescription("Idem na hijinu Raceka");
        event.setDate(LocalDateTime.of(2020, Month.JUNE, 15, 7, 0));
        result.add(event);

        event = new Event();
        event.setName("Issik-Kul");
        event.setDescription("Edem na issik-kul v 4olpon-atu");
        event.setDate(LocalDateTime.of(2020, Month.JULY, 1, 5, 0));
        result.add(event);

        return result;
    }


}
