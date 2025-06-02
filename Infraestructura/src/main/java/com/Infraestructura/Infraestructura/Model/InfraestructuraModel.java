package com.Infraestructura.Infraestructura.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "infraestructuras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfraestructuraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(nullable = false)
    private Boolean disponible;

    // Puedes agregar más campos según tus necesidades
}