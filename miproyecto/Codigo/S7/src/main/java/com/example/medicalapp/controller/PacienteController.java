package com.example.medicalapp.controller;

import com.example.medicalapp.dto.PacienteDTO;
import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.service.PacienteService;
import com.example.medicalapp.service.PacienteMapper;
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
    public List<PacienteDTO> listar() {
        return PacienteMapper.toDTOList(service.obtenerTodos());
    }

    @PostMapping
    public PacienteDTO crear(@RequestBody PacienteDTO dto) {
        Paciente paciente = PacienteMapper.toEntity(dto);
        return PacienteMapper.toDTO(service.guardar(paciente));
    }
}