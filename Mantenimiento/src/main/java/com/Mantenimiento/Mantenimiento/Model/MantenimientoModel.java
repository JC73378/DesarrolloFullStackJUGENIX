package com.Mantenimiento.Mantenimiento.Model;

import jakarta.persistence.*; 
import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "mantenimientos")  
@Data 
@NoArgsConstructor  
@AllArgsConstructor  
public class MantenimientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false) 
    private String nombreSala;  

    private String descripcion;

    private String fechaMantenimiento;  

    private Boolean completado;  

    
}