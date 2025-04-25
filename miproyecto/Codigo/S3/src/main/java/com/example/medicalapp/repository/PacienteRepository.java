package com.example.medicalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medicalapp.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
