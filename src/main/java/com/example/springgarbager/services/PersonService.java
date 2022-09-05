package com.example.springgarbager.services;

import com.example.springgarbager.model.Container;
import com.example.springgarbager.model.Person;
import com.example.springgarbager.repositories.ContainerRepository;
import com.example.springgarbager.repositories.PersonRepository;
import com.sun.tools.javac.util.DefinedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    //Este metodo permite guardar
    public Person save(Person entity) throws Exception {
        try {
            entity = personRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    //Este metodo permite Actualizar mediante ID
    public Person update(Integer id, Person entity) throws Exception {
        try {
            Optional<Person> entityOptional = personRepository.findById(id);
            Person person = entityOptional.get();
            person = personRepository.save(entity);
            return person;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean delete(Integer id) throws Exception {
        try {
            if (personRepository.existsById(id)) {
                personRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
   //Validar login


}
