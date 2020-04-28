package com.example.demo.repository;

import com.example.demo.model.FoodType;
import com.example.demo.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodTypeRepository extends JpaRepository<FoodType, Integer> {

    @Query("select p from FoodType as p where p.name like concat(:name, '%')")
    public List<FoodType>getByName(String name);
}
