package com.ciclo3.reto.reto5.controlador;

import com.ciclo3.reto.reto5.entidad.Score;
import com.ciclo3.reto.reto5.servicio.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*")
public class ApiScore {
    @Autowired
    private ScoreService service;

    @GetMapping("/all")
    public List<Score> getScores() {
        return service.getScores();
    }

    @GetMapping("/{id}")
    public Score getScore(@PathVariable long idScore) {
        return service.getScore(idScore);
    }

    @PostMapping("/save")
    public ResponseEntity saveScore(@RequestBody Score score) {
        service.saveScore(score);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateScore(@RequestBody Score score) {
        service.updateScore(score);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteScore(@PathVariable long idScore) {
        service.deleteScore(idScore);
        return ResponseEntity.status(204).build();
    }
}
