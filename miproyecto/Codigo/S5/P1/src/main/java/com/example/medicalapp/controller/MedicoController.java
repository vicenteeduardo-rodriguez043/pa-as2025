package com.example.medicalapp.controller;

import com.example.medicalapp.entity.Medico;
import com.example.medicalapp.service.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medico> listar() {
        return service.obtenerTodos();
    }

    @PostMapping
    public Medico crear(@RequestBody Medico medico) {
        return service.guardar(medico);
    }
}