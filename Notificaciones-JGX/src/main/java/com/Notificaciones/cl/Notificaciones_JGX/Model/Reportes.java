package com.Notificaciones.cl.Notificaciones_JGX.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reportes")
public class Reportes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre_profesor;

    @Column(nullable = false)
    private String tipo_notificacion;
    

    @Column(nullable=false)
    private String nivel_urgencia;
    

    @Column(nullable=true)
    private LocalDate fecha;

    
    @Column(nullable = false)
    private String detalle_notificacion;


}






