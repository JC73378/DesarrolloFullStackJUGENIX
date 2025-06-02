package com.jugenix.autenticacion.controller;

import com.jugenix.autenticacion.model.Credencial;
import com.jugenix.autenticacion.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Credencial registrar(@RequestBody Credencial credencial) {
        return authService.registrar(credencial); // Pasa la lógica al service
    }

    @PostMapping("/login")
    public String login(@RequestBody Credencial credencial) {
        return authService.login(credencial.getCorreo(), credencial.getPassword()); // Igual
    }
}
