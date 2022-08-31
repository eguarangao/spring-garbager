package com.example.springgarbager.controller;

import com.example.springgarbager.model.Container;
import com.example.springgarbager.services.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/container")
@CrossOrigin("*")
public class ContainerController {
    @Autowired
    private ContainerService containerService;

    @GetMapping
    public ResponseEntity<List<Container>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(containerService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "{id}")
    public ResponseEntity<Container> findById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(containerService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Container> create (@RequestBody Container entity)
    {
        try
        {
            return ResponseEntity.ok().body(containerService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

}
