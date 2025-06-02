package com.jugenix.usuarios.repository;

import com.jugenix.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marca como repositorio JPA
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Buscar un usuario por su correo
    Usuario findByCorreo(String correo);
}
