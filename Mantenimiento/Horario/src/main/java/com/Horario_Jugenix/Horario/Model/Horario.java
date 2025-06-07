package com.Horario_Jugenix.Horario.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Date horaInicio;

    @Column(nullable= true)
    private Date horaFin;

    @Column(nullable= false)
    private String dia;

    @Column(nullable = false)
    private String idUsuario;

    @Column(nullable=false)
    private String CodigoSala;
}
