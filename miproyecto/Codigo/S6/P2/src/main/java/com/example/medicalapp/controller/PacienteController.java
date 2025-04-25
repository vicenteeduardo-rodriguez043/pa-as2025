package com.example.medicalapp.controller;

import com.example.medicalapp.dto.PacienteDTO;
import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.mapper.PacienteMapper;
import com.example.medicalapp.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;
    private final PacienteMapper mapper;

    public PacienteController(PacienteService service, PacienteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PacienteDTO> listar() {
        return mapper.toDTOs(service.obtenerTodos());
    }

    @PostMapping
    public PacienteDTO crear(@RequestBody PacienteDTO dto) {
        Paciente paciente = mapper.toEntity(dto);
        Paciente guardado = service.guardar(paciente);
        return mapper.toDTO(guardado);
    }
}