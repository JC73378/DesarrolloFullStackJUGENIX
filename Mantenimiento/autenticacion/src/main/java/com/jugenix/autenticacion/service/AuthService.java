package com.jugenix.autenticacion.service;

import com.jugenix.autenticacion.model.Credencial;
import com.jugenix.autenticacion.repository.CredencialRepository;
import com.jugenix.autenticacion.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Marca esta clase como servicio para ser inyectado
public class AuthService {

    @Autowired
    private CredencialRepository credencialRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // Lógica para registrar una nueva credencial
    public Credencial registrar(Credencial credencial) {
        return credencialRepository.save(credencial);
    }

    // Lógica de login: valida y devuelve token JWT
    public String login(String correo, String password) {
        Credencial c = credencialRepository.findByCorreo(correo);
        if (c != null && c.getPassword().equals(password)) {
            return jwtUtil.generateToken(correo);
        } else {
            return "Credenciales inválidas";
        }
    }
}
