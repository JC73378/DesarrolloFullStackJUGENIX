package com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salas")
public class Salas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_reserva", nullable = false)
    private String nombreReserva;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "codigo_sala", nullable = false)
    private String codigoSala;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "fecha_reserva", nullable = false)
    private Date fechaReserva;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "estado_sala", nullable = false)
    private String estadoSala;
}
