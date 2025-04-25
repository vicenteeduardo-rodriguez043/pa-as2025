package com.example.medicalapp.controller;

import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente) {
        return service.guardar(paciente);
    }
}