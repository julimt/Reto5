package com.ciclo3.reto.reto5.controlador;

import com.ciclo3.reto.reto5.entidad.Room;
import com.ciclo3.reto.reto5.servicio.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Room/")
public class ApiRoom {
    @Autowired
    private RoomService service;

    @GetMapping("/all")
    public List<Room> findAllRooms(){
        return service.getRooms();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable long id) {
        return service.getRoom(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveRoom(@RequestBody Room room){
        service.saveRoom(room);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateRoom(@RequestBody Room room) {
        service.updateRoom(room);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoom(@PathVariable long id) {
        service.deleteRoom(id);
        return ResponseEntity.status(204).build();
    }
}
