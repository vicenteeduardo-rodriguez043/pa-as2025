package com.example.medicalapp.service;

import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Paciente> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}