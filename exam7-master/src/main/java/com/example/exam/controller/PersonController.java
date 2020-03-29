package com.example.exam.controller;

import com.example.exam.dto.PersonDTO;
import com.example.exam.model.Person;
import com.example.exam.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.exam.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO addNew(@RequestBody PersonDTO personDTO) {
        Person person = personService.addPerson(new Person(personDTO.getName(), personDTO.getEmail(), personDTO.getPassword()));
        return new PersonDTO(person.getId(),person.getEmail(), person.getName(), person.getPassword());
    }

    @DeleteMapping(path = "/del/{email}")
    public PersonDTO deleteByEmail(@PathVariable String email) {
        Person person = personService.deleteByEmail(email);
        return new PersonDTO(person.getId(),person.getEmail(), person.getName(), person.getPassword());
    }

    @GetMapping(path = "/get/{email}")
    public Person getByEmail(@PathVariable String email) {
        return personService.getByEmail(email);
    }

    @GetMapping(path = "/all")
    public List<Person> findAll() {
        return personService.findAll();
    }
}
