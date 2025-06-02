package com.jugenix.autenticacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // Indica que esta clase será una tabla en la BD
@Data // Lombok genera automáticamente getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincremental
    private Long id;

    @Column(unique = true, nullable = false) // El correo no se puede repetir ni dejar vacío
    private String correo;

    @Column(nullable = false) // El password es obligatorio
    private String password;
}
