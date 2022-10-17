package com.ciclo3.reto.reto5.repositorio;


import com.ciclo3.reto.reto5.entidad.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score,Long> {
}
