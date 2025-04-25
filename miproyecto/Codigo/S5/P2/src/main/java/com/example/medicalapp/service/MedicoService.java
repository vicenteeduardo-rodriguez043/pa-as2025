package com.example.medicalapp.service;

import com.example.medicalapp.entity.Medico;
import com.example.medicalapp.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    private final MedicoRepository repository;
    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public List<Medico> obtenerTodos() {
        return repository.findAll();
    }

    public Medico guardar(Medico medico) {
        return repository.save(medico);
    }
}