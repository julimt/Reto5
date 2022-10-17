package com.ciclo3.reto.reto5.controlador;


import com.ciclo3.reto.reto5.entidad.Client;
import com.ciclo3.reto.reto5.servicio.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*")
public class ApiClient {
    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> getClients() {
        return service.getClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable long idClient) {
        return service.getClient(idClient);
    }

    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody Client client) {
        service.saveClient(client);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client client) {
        service.updateClient(client);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable long id) {
        service.deleteClient(id);
        return ResponseEntity.status(204).build();
    }
}
