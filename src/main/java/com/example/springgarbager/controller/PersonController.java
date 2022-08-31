package com.example.springgarbager.controller;

import com.example.springgarbager.model.Container;
import com.example.springgarbager.model.Person;
import com.example.springgarbager.services.ContainerService;
import com.example.springgarbager.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin("*")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(personService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "{id}")
    public ResponseEntity<Person> findById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(personService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Person> create (@RequestBody Person entity)
    {
        try
        {
            return ResponseEntity.ok().body(personService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Person>update(@PathVariable int id, @RequestBody Person entity)
    {
        try
        {
            return ResponseEntity.ok().body(personService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
