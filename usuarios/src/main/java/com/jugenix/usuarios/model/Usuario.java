package com.jugenix.usuarios.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // Esta clase será una tabla en la base de datos
@Data // Lombok: genera getters, setters, etc.
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincremental
    private Long id;

    private String nombre; // Nombre del usuario
    private String correo; // Correo del usuario
    private String telefono; // Teléfono de contacto
    private String rol; // Rol del usuario (Ej: estudiante, técnico)
}
