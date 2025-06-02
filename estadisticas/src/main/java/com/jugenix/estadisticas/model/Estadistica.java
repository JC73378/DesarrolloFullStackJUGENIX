package com.jugenix.estadisticas.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity // Tabla estadistica en la BD
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estadistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Tipo de estadística (ej: usuarios, reservas)
    private int cantidad; // Valor numérico

    private LocalDateTime fecha; // Fecha en que se registró la estadística
}
