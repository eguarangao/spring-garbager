package com.example.springgarbager.repositories;

import com.example.springgarbager.model.Garbage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarbageRepository extends JpaRepository<Garbage,Integer> {
}
