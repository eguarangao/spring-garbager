package com.example.springgarbager.services;

import com.example.springgarbager.model.Container;
import com.example.springgarbager.model.Person;
import com.example.springgarbager.repositories.ContainerRepository;
import com.example.springgarbager.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    //Este metodo permite listar los contenedores
    public List<Person> findAll() throws Exception {
        try {
            return personRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    public Person findById(Integer id) throws Exception {
        try {
            Optional<Person> entityOptional = personRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
