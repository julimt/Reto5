package com.ciclo3.reto.reto5.repositorio;


import com.ciclo3.reto.reto5.entidad.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countReservationsByClients();

    //SELECT * FROM Reservation WHERE starDate AFTER fechainicio AND devolutionDate BEFORE fechafin
    @Query("SELECT d FROM Reservation AS d WHERE d.startDate BETWEEN ?1 AND ?2 ")
    public List<Reservation> fechaReservation(Date dateA, Date dateB);

    //SELECT * FROM Reservation WHERE status = 'cancelled'
    public List<Reservation> findAllByStatus(String status);

}

