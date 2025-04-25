package com.example.medicalapp.controller;

import com.example.medicalapp.dto.PacienteDTO;
import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.service.PacienteService;
import com.example.medicalapp.service.PacienteMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
        return service.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Paciente> crear(@Valid @RequestBody PacienteDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNombre(dto.getNombre());
        paciente.setCorreo(dto.getCorreo());
        return ResponseEntity.ok(service.guardar(paciente));
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public List<Paciente> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar/correo/{fragmento}")
    public List<Paciente> buscarPorCorreo(@PathVariable String fragmento) {
        return service.buscarPorCorreo(fragmento);
    }
}