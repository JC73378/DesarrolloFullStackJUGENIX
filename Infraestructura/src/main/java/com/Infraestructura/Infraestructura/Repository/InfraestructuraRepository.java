package com.Infraestructura.Infraestructura.Repository;

import com.Infraestructura.Infraestructura.Model.InfraestructuraModel;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfraestructuraRepository extends JpaRepository<InfraestructuraModel, Long> {

    Optional<InfraestructuraModel> findByNombre(String nombre);
    // Métodos personalizados (si los necesitas)
}
