package com.example.exam.controller;

import com.example.exam.dto.PersonDTO;
import com.example.exam.model.Food;
import com.example.exam.model.Person;
import com.example.exam.service.FoodService;
import com.example.exam.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Food addNew(@RequestBody Food food) {
        return foodService.addFood(food);
    }

    @DeleteMapping(path = "/del/{foodId}")
    public Food deleteById(@PathVariable String foodId) {
        return foodService.deleteById(foodId);
    }

    @GetMapping(path = "/get/{foodId}")
    public Food getById(@PathVariable String foodId) {
        return foodService.getById(foodId);
    }

    @GetMapping(path = "/all")
    public List<Food> findAll() {
        return foodService.getAll();
    }
}
