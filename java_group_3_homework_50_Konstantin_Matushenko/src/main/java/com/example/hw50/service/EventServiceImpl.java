package com.example.hw50.service;

import com.example.hw50.model.Event;
import com.example.hw50.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl {

    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event) {
        event.setDate(LocalDateTime.now());
        return eventRepository.save(event);
    }

    public void deleteEventById(String eventId) {
        eventRepository.deleteById(eventId);
    }

    public boolean existsById (String eventId) {
        return eventRepository.existsById(eventId);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event getById(String eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public void deleteAll() {
        eventRepository.deleteAll();
    }
}
