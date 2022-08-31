package com.example.springgarbager.repositories;

import com.example.springgarbager.model.Container;
import com.example.springgarbager.model.Garbage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainerRepository extends JpaRepository<Container,Integer> {

}
