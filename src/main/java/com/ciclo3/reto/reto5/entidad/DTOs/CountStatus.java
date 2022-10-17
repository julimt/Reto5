package com.ciclo3.reto.reto5.entidad.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountStatus {
    private Long completed;
    private Long cancelled;
}
