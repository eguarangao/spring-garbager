package com.example.springgarbager.controller;

import com.example.springgarbager.model.Person;
import com.example.springgarbager.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/email")
@CrossOrigin("*")
public class PersonFinByEmailController {
    @Autowired
    private PersonRepository personRepository;
    @RequestMapping(value = "{email}")
    public ResponseEntity<Person> finfById(@PathVariable("email")String email)
    {
        try
        {
            return ResponseEntity.ok().body(personRepository.findCarerByEmail(email));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
}
