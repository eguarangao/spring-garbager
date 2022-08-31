package com.example.springgarbager.services;

import com.example.springgarbager.model.Container;
import com.example.springgarbager.model.PersonContainer;
import com.example.springgarbager.repositories.ContainerRepository;
import com.example.springgarbager.repositories.PersonContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PersonContainerService {
    @Autowired
    private PersonContainerRepository personContainerRepository;
    //Este metodo permite listar los contenedores
    public List<PersonContainer> findAll() throws Exception {
        try {
            return personContainerRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
