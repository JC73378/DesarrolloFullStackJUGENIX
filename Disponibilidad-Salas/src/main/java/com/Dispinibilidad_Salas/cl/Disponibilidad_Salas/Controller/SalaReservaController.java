package com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Service.SalaReservaService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.Dispinibilidad_Salas.cl.Disponibilidad_Salas.Model.Salas;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;

// Esta clase es un controlador REST que maneja las solicitudes HTTP relacionadas con las reservas de salas
@RestController
// Indica que todas las rutas dentro de este controlador empezarán con "/api/salas"
@RequestMapping("/api/salas")
public class SalaReservaController {

    // Inyectamos el servicio que contiene la lógica para manejar las reservas
    @Autowired
    private SalaReservaService salaReservaService;

    // Endpoint para obtener todas las reservas de salas
    @GetMapping("/reservas")
    public ResponseEntity<List<Salas>> obtenerTodasLasReservas() {
        List<Salas> reservas = salaReservaService.obtenerSalasReservadas();
        return ResponseEntity.ok(reservas);
    }

    // Endpoint para crear una nueva reserva de sala
    // Se accede mediante una petición POST a /api/salas/reservar
   @PostMapping("/reservar")
    public ResponseEntity<?> reservarSala(@RequestBody Salas nuevaReserva) {
    try {
        Salas reservaCreada = salaReservaService.crearReserva(nuevaReserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaCreada);
    } catch (IllegalStateException e) {
        // Si la sala ya está reservada para esa fecha, responde con un error 409 (conflict)
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    } catch (Exception e) {
        // Manejo de otros errores generales
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la reserva.");
    }
    }
    // Endpoint para obtener una reserva por el código de sala
    // Se accede mediante una petición GET a /api/salas/{codigoSala}
    @GetMapping("/{codigoSala}")
    public Salas obtenerReservaPorCodigo(@PathVariable String codigoSala) {
         // Busca una reserva con el código dado. Si no se encuentra, lanza una excepción.
        return salaReservaService.obtenerReservaPorCodigo(codigoSala)
                .orElseThrow(() -> new IllegalStateException("Reserva no encontrada."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelarReserva(@PathVariable Long id) {
        try {
            salaReservaService.cancelarReserva(id);
            return ResponseEntity.ok("Reserva cancelada exitosamente.");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
}
