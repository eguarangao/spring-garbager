package com.example.springgarbager.services;

import com.example.springgarbager.model.Container;
import com.example.springgarbager.repositories.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class ContainerService {
    @Autowired
    private ContainerRepository containerRepository;
    //Este metodo permite listar los contenedores
    public List<Container> findAll() throws Exception {
        try {
            return containerRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    //Este metodo permite buscar mediante su ID.
    public Container findById(Integer id) throws Exception {
        try {
            Optional<Container> entityOptional = containerRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    //Este metodo permite guardar
    public Container save(Container entity) throws Exception {
        try {
            entity = containerRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    //Este metodo permite Actualizar mediante ID
    public Container update(Integer id, Container entity) throws Exception {
        try {
            Optional<Container> entityOptional = containerRepository.findById(id);
            Container container = entityOptional.get();
            container = containerRepository.save(entity);
            return container;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean delete(Integer id) throws Exception {
        try {
            if (containerRepository.existsById(id)) {
                containerRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
