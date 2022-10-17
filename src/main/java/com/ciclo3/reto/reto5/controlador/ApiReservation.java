package com.ciclo3.reto.reto5.controlador;

import com.ciclo3.reto.reto5.entidad.DTOs.CountClient;
import com.ciclo3.reto.reto5.entidad.DTOs.CountStatus;
import com.ciclo3.reto.reto5.entidad.Reservation;
import com.ciclo3.reto.reto5.servicio.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Reservation/")
public class ApiReservation {
    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable long idReservation) {
        return service.getReservation(idReservation);
    }

    @PostMapping("/save")
    public ResponseEntity saveReservation(@RequestBody Reservation reservation) {
        service.saveReservation(reservation);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateReservation(@RequestBody Reservation reservation) {
        service.updateReservation(reservation);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable long idReservation) {
        service.deleteReservation(idReservation);
        return ResponseEntity.status(204).build();
    }

    //Reto 5
    @GetMapping("/report-clients")
    public List<CountClient> getTopClients() {
        return service.getTopClients();
    }

    @GetMapping("/report-dates/{dateA}/{dateB}")
    public List<Reservation> getReservationsReportDates
    (@PathVariable String dateA, @PathVariable String dateB) {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        Date c1 = new Date();
        Date c2 = new Date();
        try {
            c1 = in.parse(dateA);
            c2 = in.parse(dateB);
        } catch (ParseException ex) {
        }
        return service.getFechaReservation(c1,c2);
    }

    @GetMapping("/report-status")
    public CountStatus getReportReservationStatus() {
        return service.getReservationStatus();
    }


}
