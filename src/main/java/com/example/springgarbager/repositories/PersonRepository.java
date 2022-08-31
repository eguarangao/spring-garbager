package com.example.springgarbager.repositories;

import com.example.springgarbager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person,Integer>{
}
