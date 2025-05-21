package com.SoporteTecnico.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
@Table(name = "ticket_soporte")
public class TicketSoporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String asunto;


    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = true)
    private Date fechaCreacion;

    @Column(nullable = true)    
    private Date fechaResolucion;

    @Column(nullable = false)
    private String estado;

}
