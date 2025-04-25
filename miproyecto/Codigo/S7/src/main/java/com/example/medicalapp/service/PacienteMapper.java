package com.example.medicalapp.service;

import com.example.medicalapp.dto.PacienteDTO;
import com.example.medicalapp.entity.Paciente;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteMapper {
    public static PacienteDTO toDTO(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setId(paciente.getId());
        dto.setNombre(paciente.getNombre());
        dto.setCorreo(paciente.getCorreo());
        return dto;
    }

    public static Paciente toEntity(PacienteDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setId(dto.getId());
        paciente.setNombre(dto.getNombre());
        paciente.setCorreo(dto.getCorreo());
        return paciente;
    }

    public static List<PacienteDTO> toDTOList(List<Paciente> pacientes) {
        return pacientes.stream().map(PacienteMapper::toDTO).collect(Collectors.toList());
    }
}