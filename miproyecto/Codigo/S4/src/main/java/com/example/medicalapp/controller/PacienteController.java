package com.example.medicalapp.controller;

import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> listarPacientes() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> obtenerPaciente(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return service.guardar(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        return service.guardar(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        service.eliminar(id);
    }
}