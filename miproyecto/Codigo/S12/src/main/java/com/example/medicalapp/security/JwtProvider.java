package com.example.medicalapp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private final String SECRET_KEY = "mi_clave_secreta";

    public String generarToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
    }
}