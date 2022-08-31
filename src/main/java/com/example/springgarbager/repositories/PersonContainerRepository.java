package com.example.springgarbager.repositories;

import com.example.springgarbager.model.PersonContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonContainerRepository extends JpaRepository<PersonContainer,Integer> {
}
