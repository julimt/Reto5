package com.ciclo3.reto.reto5.controlador;

import com.ciclo3.reto.reto5.entidad.Admin;
import com.ciclo3.reto.reto5.servicio.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")

public class ApiAdmin {
    @Autowired
    private AdminService service;

    @GetMapping("/all")
    public List<Admin> getAdmins() {
        return service.getAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable long idAdmin) {
    return service.getAdmin(idAdmin);
    }

    @PostMapping("/save")
    public ResponseEntity saveAdmin(@RequestBody Admin admin) {
        service.saveAdmin(admin);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody Admin admin) {
        service.updateAdmin(admin);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdmin(@PathVariable long idAdmin) {
        service.deleteAdmin(idAdmin);
        return ResponseEntity.status(204).build();
    }
}
