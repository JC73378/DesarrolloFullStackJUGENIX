package com.jugenix.estadisticas.service;

import com.jugenix.estadisticas.model.Estadistica;
import com.jugenix.estadisticas.repository.EstadisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticaService {

    @Autowired
    private EstadisticaRepository repository;

    // Obtener todas las estadísticas registradas
    public List<Estadistica> listar() {
        return repository.findAll();
    }

    // Registrar una nueva estadística
    public Estadistica crear(Estadistica estadistica) {
        estadistica.setFecha(java.time.LocalDateTime.now());
        return repository.save(estadistica);
    }

    // Eliminar una estadística
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
