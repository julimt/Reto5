package com.ciclo3.reto.reto5.controlador;

import com.ciclo3.reto.reto5.entidad.Category;
import com.ciclo3.reto.reto5.servicio.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")

public class ApiCategory {
    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public List<Category> getCategories() {
        return service.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable long id) {
        return service.getCategory(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveCategory(@RequestBody Category category) {
        service.saveCategory(category);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category) {
        service.updateCategory(category);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id) {
        service.deleteCategory(id);
        return ResponseEntity.status(204).build();
    }
}
