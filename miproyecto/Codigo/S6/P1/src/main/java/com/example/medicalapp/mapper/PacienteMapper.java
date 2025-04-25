package com.example.medicalapp.mapper;

import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.dto.PacienteDTO;

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
}