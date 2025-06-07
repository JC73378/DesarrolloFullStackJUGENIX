package com.jugenix.autenticacion.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component // Hace que esta clase pueda ser inyectada automáticamente
public class JwtUtil {

    private final String SECRET_KEY = "jugenixSecret"; // Clave secreta para firmar el token

    // Genera un token válido por 1 hora para el correo recibido
    public String generateToken(String correo) {
        return Jwts.builder()
                .setSubject(correo) // Quien es el dueño del token
                .setIssuedAt(new Date()) // Fecha de creación
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Firma el token con algoritmo y clave
                .compact();
    }

    // Verifica que el token sea válido y no esté vencido
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extrae el correo desde el token
    public String extractCorreo(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token)
                .getBody().getSubject();
    }
}
