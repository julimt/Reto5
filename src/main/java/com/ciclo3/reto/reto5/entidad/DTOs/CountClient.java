package com.ciclo3.reto.reto5.entidad.DTOs;

import com.ciclo3.reto.reto5.entidad.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountClient {
    private Long total;
    private Client client;
}
