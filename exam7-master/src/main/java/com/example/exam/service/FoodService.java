package com.example.exam.service;

import com.example.exam.model.Food;
import com.example.exam.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public void deleteAll() {
        foodRepository.deleteAll();
    }

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food deleteById(String foodId) {
        if (foodRepository.existsById(foodId)) {
            Food food = foodRepository.findById(foodId).get();
            foodRepository.deleteById(foodId);
            return food;
        }
        return null;
    }

    public Food getById(String foodId) {
        return foodRepository.findById(foodId).orElse(null);
    }

    public List<Food> findAllById(List<String> foodIds) {
        List<Food> result = new ArrayList<>();

        for (String id : foodIds) {
            result.add(getById(id));
        }

        return result;
    }

}
