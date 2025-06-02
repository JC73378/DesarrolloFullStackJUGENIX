package com.jugenix.usuarios.service;

import com.jugenix.usuarios.model.Usuario;
import com.jugenix.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Componente de lógica de negocio
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // Crear nuevo usuario
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar usuario por ID
    public Usuario actualizar(Long id, Usuario datos) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(); // Lanza error si no existe
        usuario.setNombre(datos.getNombre());
        usuario.setCorreo(datos.getCorreo());
        usuario.setTelefono(datos.getTelefono());
        usuario.setRol(datos.getRol());
        return usuarioRepository.save(usuario);
    }

    // Eliminar usuario por ID
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
