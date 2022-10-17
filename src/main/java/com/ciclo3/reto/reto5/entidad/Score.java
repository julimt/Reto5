package com.ciclo3.reto.reto5.entidad;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idScore;
    private String messageText;
    private Integer stars;
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;
}
