package com.example.exam.service;

import com.example.exam.model.Place;
import com.example.exam.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    public void deleteAll() {
        placeRepository.deleteAll();
    }

    public Place deleteById(String placeId) {
        if (placeRepository.existsById(placeId)) {
            Place place = placeRepository.findById(placeId).orElse(null);
            placeRepository.deleteById(placeId);
            return place;
        }
        return null;
    }

    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public Place findById(String placeId) {
       return placeRepository.findById(placeId).orElse(null);
    }
}
