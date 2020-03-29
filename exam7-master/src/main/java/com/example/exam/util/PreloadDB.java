package com.example.exam.util;

//import com.example.hw54.model.Event;
//import com.example.hw54.model.User;
//import com.example.hw54.service.EventService;
//import com.example.hw54.service.SubscriptionService;
//import com.example.hw54.service.UserService;
import com.example.exam.SecurityConfig;
import com.example.exam.model.Food;
import com.example.exam.model.Order;
import com.example.exam.model.Person;
import com.example.exam.model.Place;
import com.example.exam.service.FoodService;
import com.example.exam.service.OrderService;
import com.example.exam.service.PersonService;
import com.example.exam.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Configuration
public class PreloadDB {

    private PersonService personService;
    private FoodService foodService;
    private PlaceService placeService;
    private OrderService orderService;

    private Random random = new Random();

    @Autowired
    public PreloadDB(PersonService personService,
                     FoodService foodService,
                     PlaceService placeService,
                     OrderService orderService) {
        this.personService = personService;
        this.foodService = foodService;
        this.placeService = placeService;
        this.orderService = orderService;
    }

    @Bean
    public void initDB() {

        personService.deleteAll();
        foodService.deleteAll();
        placeService.deleteAll();
        orderService.deleteAll();

        personService.addPerson(new Person("Fedor", "admin", new SecurityConfig().encoder().encode("1")));
        for (int i = 0; i < 300; i++) {
            personService.addPerson(new Person(GenerateData.randomPersonName(), GenerateData.randomEmail(), new SecurityConfig().encoder().encode("123")));
        }

        for (int i = 0; i < 50; i++) {
            GenerateData.DishName dishName = GenerateData.randomDish();
            foodService.addFood(new Food(dishName.getName(), dishName.getType(), random.nextInt(1000) + 20));
        }

        List<String> foodIds = foodService.getAll().stream().map(Food::getId).collect(Collectors.toList());

        int start = 0;
        int finish = 5;

        for (int i = 0; i < 5; i++) {
            GenerateData.PlaceName placeName = GenerateData.randomPlace();
            List<String> foods = new ArrayList<>();
            for (int j = start; j < finish; j++) {
                foods.add(foodIds.get(j));
            }
            placeService.addPlace(new Place(placeName.getName(), placeName.getDescription(), foods));
            start = start + 5;
            finish = finish + 5;
        }

        List<Person> personList = personService.getAll();
        for (int i = 0; i < 10; i++) {
            String personEmail = personList.get(i).getEmail();
            String foodId = foodIds.get(i);
            orderService.addOrder(new Order(personEmail, foodId));
        }


    }
}
