package com.ciclo3.reto.reto5.servicio;

import com.ciclo3.reto.reto5.entidad.Score;
import com.ciclo3.reto.reto5.repositorio.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;

    // GET
    public List<Score> getScores(){
        return repository.findAll();
    }

    public Score getScore(long idScore) {return repository.findById(idScore).orElse(null);}

    //Peticion POST
    public Score saveScore(Score score) {
        return repository.save(score);
    }

    //PUT=UPDATE
    public Score updateScore(Score scoreUpd) {
        Score scoreOld = getScore(scoreUpd.getIdScore());
        scoreOld.setMessageText(scoreUpd.getMessageText());
        scoreOld.setStars(scoreUpd.getStars());
        return repository.save(scoreOld);
    }

    //DELETE
    public void deleteScore(long idScore){
        repository.deleteById(idScore);
    }
}
