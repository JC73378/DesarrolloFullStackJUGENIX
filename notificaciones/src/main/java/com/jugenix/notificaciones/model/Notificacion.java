package com.jugenix.notificaciones.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinatario; // puede ser correo o nombre de usuario
    private String mensaje;
    private String tipo; // ejemplo: "reserva", "soporte", "sistema"

    private LocalDateTime fechaHora;
}
