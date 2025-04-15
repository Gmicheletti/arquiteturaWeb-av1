package com.example.av1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.av1.model.Cursos;
import com.example.av1.service.CursosService;

@RestController
@RequestMapping("/cursos")
public class CursosController {
    @Autowired
    private CursosService cursosService;

    @GetMapping
    public List<Cursos> getAll(){
        return cursosService.findAll();
    }

    @PostMapping
    public Cursos create(@RequestBody Cursos curso){
        return cursosService.save(curso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> getCurso(@PathVariable Long id){
        return cursosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cursos> updateCurso(@PathVariable Long id, @RequestBody Cursos curso){
        return cursosService.update(id, curso)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return cursosService.delete(id);
    }
}

