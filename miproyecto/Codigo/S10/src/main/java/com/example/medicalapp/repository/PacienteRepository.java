package com.example.medicalapp.repository;

import com.example.medicalapp.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNombre(String nombre);

    @Query("SELECT p FROM Paciente p WHERE p.correo LIKE %:fragmento%")
    List<Paciente> buscarPorCorreo(String fragmento);
}