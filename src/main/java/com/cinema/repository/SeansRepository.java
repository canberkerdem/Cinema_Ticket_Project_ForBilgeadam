package com.cinema.repository;

import com.cinema.entity.Seans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeansRepository extends JpaRepository<Seans,Long> {


    Optional<Seans> getById(Long id);
}
