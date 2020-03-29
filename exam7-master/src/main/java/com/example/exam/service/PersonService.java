package com.example.exam.service;

import com.example.exam.SecurityConfig;
import com.example.exam.model.Person;
import com.example.exam.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        if (!personRepository.existsByEmail(person.getEmail())) {
            Person person1 = person;
            person1.setPassword(new SecurityConfig().encoder().encode(person.getPassword()));
            return personRepository.save(person1);
        }
        return null;
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person deleteByEmail(String email) {
        if (personRepository.existsByEmail(email)) {
            Person person = personRepository.findByEmail(email);
            personRepository.deleteByEmail(email);
            return person;
        }
        return null;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person getByEmail(String email) {
        return personRepository.findByEmail(email);
    }
}
