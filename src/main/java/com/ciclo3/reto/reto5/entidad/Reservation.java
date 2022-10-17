package com.ciclo3.reto.reto5.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="";
    @ManyToOne
    @JoinColumn(name = "reservation_id_room")
    @JsonIgnoreProperties("reservations")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "reservation_id_client")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;

}
