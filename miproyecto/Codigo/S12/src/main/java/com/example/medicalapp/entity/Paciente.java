package com.example.medicalapp.entity;

import jakarta.persistence.*;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;

    // Getters y Setters
}