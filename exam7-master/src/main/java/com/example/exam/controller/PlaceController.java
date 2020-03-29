package com.example.exam.controller;

import com.example.exam.model.Food;
import com.example.exam.model.Place;
import com.example.exam.service.FoodService;
import com.example.exam.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private PlaceService placeService;
    private FoodService foodService;

    @Autowired
    public PlaceController(PlaceService placeService, FoodService foodService) {
        this.placeService = placeService;
        this.foodService = foodService;
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Place addPlace(@RequestBody Place place) {
        return placeService.addPlace(place);
    }

    @DeleteMapping(path = "/del/{placeId}")
    public Place deleteById(@PathVariable String placeId) {
        return placeService.deleteById(placeId);
    }

    @GetMapping(path = "/all")
    public List<Place> findAll() {
        return placeService.findAll();
    }

    @GetMapping(path = "/all/{placeId}")
    public List<Food> findFoodByPlace(@PathVariable String placeId) {
        List<String> foodIds = placeService.findById(placeId).getFoods();
        return foodService.findAllById(foodIds);
    }
}
