package com.example.hw54.service;

import com.example.hw54.model.Event;
import com.example.hw54.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void addAll(List<Event> events) {
        eventRepository.saveAll(events);
    }

}
