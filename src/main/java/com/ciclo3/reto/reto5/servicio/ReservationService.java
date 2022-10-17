package com.ciclo3.reto.reto5.servicio;

import com.ciclo3.reto.reto5.entidad.Client;
import com.ciclo3.reto.reto5.entidad.DTOs.CountClient;
import com.ciclo3.reto.reto5.entidad.DTOs.CountStatus;
import com.ciclo3.reto.reto5.entidad.Reservation;
import com.ciclo3.reto.reto5.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    //GET
    public List<Reservation> getReservations() {
        return repository.findAll();
    }

    public Reservation getReservation(long idReservation) {
        return repository.findById(idReservation).orElse(null);
    }

    //POST
    public Reservation saveReservation(Reservation reservation) {
        return repository.save(reservation);
    }

    //PUT=UPDATE
    public Reservation updateReservation(Reservation reservationUpd) {
        Reservation reservationOld = getReservation(reservationUpd.getIdReservation());
        reservationOld.setStartDate(reservationUpd.getStartDate());
        reservationOld.setDevolutionDate(reservationUpd.getDevolutionDate());
        reservationOld.setStatus(reservationUpd.getStatus());
        return repository.save(reservationOld);
    }

    //DELETE
    public void deleteReservation(long idReservation) {
        repository.deleteById(idReservation);
    }

    //Reto 5
    public List<CountClient> getTopClients() {
        List<CountClient> respuesta = new ArrayList<>();

        List<Object[]> reporte = repository.countReservationsByClients();

        for (int i = 0; i < reporte.size(); i++) {
            //                  [client             total]      --> [total,     client]
            respuesta.add(new CountClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

    public List<Reservation> getFechaReservation(Date dateA, Date dateB) {
        return repository.fechaReservation(dateA,dateB);
    }

    public CountStatus getReservationStatus() {
        List<Reservation> completed = repository.findAllByStatus("completed");
        List<Reservation> cancelled = repository.findAllByStatus("cancelled");
        return new CountStatus((long) completed.size(),(long) cancelled.size());
    }
}

    /*public  List<Reservation> getReportReservationsPeriod(String dataA, String dataB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(dataA);
            b = parser.parse(dataB);
        } catch (ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return
        }else{
            return new ArrayList<>();*/

    /*public List <Reservation> informePeriodoTiempoReservas(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }*/


