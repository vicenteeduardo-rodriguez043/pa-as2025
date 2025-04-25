package com.example.medicalapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {

    @GetMapping("/paciente")
    public String obtenerPaciente() {
        return "Paciente: Juan Pérez";
    }
}
