package com.example.medicalapp.mapper;

import com.example.medicalapp.dto.PacienteDTO;
import com.example.medicalapp.entity.Paciente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteDTO toDTO(Paciente paciente);
    Paciente toEntity(PacienteDTO dto);
    List<PacienteDTO> toDTOs(List<Paciente> pacientes);
}