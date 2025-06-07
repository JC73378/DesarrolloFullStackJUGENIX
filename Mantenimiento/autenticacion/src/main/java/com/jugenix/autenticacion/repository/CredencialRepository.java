package com.jugenix.autenticacion.repository;

import com.jugenix.autenticacion.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

// Interfaz que permite consultar la base de datos sin escribir SQL
public interface CredencialRepository extends JpaRepository<Credencial, Long> {
    // Método personalizado para buscar por correo
    Credencial findByCorreo(String correo);
}
