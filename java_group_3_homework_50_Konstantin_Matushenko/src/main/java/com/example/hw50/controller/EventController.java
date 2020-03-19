package com.example.hw50.controller;

import com.example.hw50.model.Event;
import com.example.hw50.model.User;
import com.example.hw50.service.EventServiceImpl;
import com.example.hw50.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventServiceImpl eventService;
    private UserServiceImpl userService;

    @Autowired
    public EventController(EventServiceImpl eventService, UserServiceImpl userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @PostMapping
    public Event addEvent(@RequestBody Event event) {

        User publisher = userService.getUserById(event.getPublisherUserId());
        User follower = userService.getUserById(event.getSubscriberUserId());

        publisher.getSubscibers().add(follower.getEmail());
        follower.getSubsciptions().add(publisher.getEmail());

        userService.updateUser(publisher);
        userService.updateUser(follower);

        return eventService.addEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @DeleteMapping("/{eventId}")
    public Event deleteById(@PathVariable String eventId) {
        if (eventService.existsById(eventId)) {
            Event event = eventService.getById(eventId);

            User publisher = userService.getUserById(event.getPublisherUserId());
            User follower = userService.getUserById(event.getSubscriberUserId());

            publisher.getSubscibers().remove(follower.getEmail());
            follower.getSubsciptions().remove(publisher.getEmail());

            userService.updateUser(publisher);
            userService.updateUser(follower);

            eventService.deleteEventById(eventId);

            return event;
        }
        return null;
    }
}
