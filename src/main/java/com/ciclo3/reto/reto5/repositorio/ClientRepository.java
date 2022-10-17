package com.ciclo3.reto.reto5.repositorio;


import com.ciclo3.reto.reto5.entidad.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
