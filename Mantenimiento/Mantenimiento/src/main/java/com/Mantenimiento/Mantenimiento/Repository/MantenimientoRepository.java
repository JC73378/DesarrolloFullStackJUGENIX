package com.Mantenimiento.Mantenimiento.Repository;

import com.Mantenimiento.Mantenimiento.Model.MantenimientoModel;
import org.springframework.data.jpa.repository.JpaRepository; //  Interfaz para operaciones CRUD
import org.springframework.stereotype.Repository;

@Repository //  Indica que esta interfaz es un repositorio de datos
public interface MantenimientoRepository extends JpaRepository<MantenimientoModel, Long> {
    // Métodos personalizados (si los necesitas)
}