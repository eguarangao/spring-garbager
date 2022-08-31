package com.example.springgarbager.repositories;

import com.example.springgarbager.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State,Integer> {
}
