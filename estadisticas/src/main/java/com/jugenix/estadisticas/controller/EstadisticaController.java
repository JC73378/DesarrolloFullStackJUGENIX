package com.jugenix.estadisticas.controller;

import com.jugenix.estadisticas.model.Estadistica;
import com.jugenix.estadisticas.service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticaController {

    @Autowired
    private EstadisticaService service;

    // Obtener todas las estadísticas
    @GetMapping
    public List<Estadistica> obtener() {
        return service.listar();
    }

    // Crear una nueva estadística
    @PostMapping
    public Estadistica crear(@RequestBody Estadistica estadistica) {
        return service.crear(estadistica);
    }

    // Eliminar estadística por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
