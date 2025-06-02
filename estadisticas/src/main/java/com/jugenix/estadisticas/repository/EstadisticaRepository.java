package com.jugenix.estadisticas.repository;

import com.jugenix.estadisticas.model.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {
    // Podrías agregar filtros por tipo o fecha en el futuro
}
