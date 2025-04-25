package com.example.medicalapp.controller;

import com.example.medicalapp.dto.PacienteDTO;
import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.mapper.PacienteMapper;
import com.example.medicalapp.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<PacienteDTO> listar() {
        return service.obtenerTodos().stream()
            .map(PacienteMapper::toDTO)
            .collect(Collectors.toList());
    }

    @PostMapping
    public PacienteDTO crear(@RequestBody PacienteDTO dto) {
        Paciente paciente = PacienteMapper.toEntity(dto);
        Paciente guardado = service.guardar(paciente);
        return PacienteMapper.toDTO(guardado);
    }
}