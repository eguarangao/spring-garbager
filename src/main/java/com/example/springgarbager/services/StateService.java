package com.example.springgarbager.services;

import com.example.springgarbager.model.Container;
import com.example.springgarbager.model.State;
import com.example.springgarbager.repositories.ContainerRepository;
import com.example.springgarbager.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;
    //Este metodo permite listar los contenedores
    public List<State> findAll() throws Exception {
        try {
            return stateRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
