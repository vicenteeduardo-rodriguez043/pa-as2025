package com.example.medicalapp.service;

import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> obtenerTodos() {
        return repository.findAll();
    }

    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }
}
