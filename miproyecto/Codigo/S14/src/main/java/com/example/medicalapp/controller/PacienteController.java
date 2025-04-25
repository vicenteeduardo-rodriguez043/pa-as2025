package com.example.medicalapp.controller;

import com.example.medicalapp.entity.Paciente;
import com.example.medicalapp.service.PacienteService;
import com.example.medicalapp.cloudinary.CloudinaryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;
    private final CloudinaryService cloudinaryService;

    public PacienteController(PacienteService service, CloudinaryService cloudinaryService) {
        this.service = service;
        this.cloudinaryService = cloudinaryService;
    }

    @GetMapping
    public List<Paciente> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Paciente crear(@RequestParam("nombre") String nombre,
                          @RequestParam("correo") String correo,
                          @RequestParam("imagen") MultipartFile imagen) throws IOException {
        String imagenUrl = cloudinaryService.subirImagen(imagen);
        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setCorreo(correo);
        paciente.setImagenUrl(imagenUrl);
        return service.guardar(paciente);
    }
}