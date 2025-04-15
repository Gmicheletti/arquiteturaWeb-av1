package com.example.av1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.av1.model.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long>{
    
}
