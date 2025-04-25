package com.example.medicalapp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String especialidad;

    @ManyToMany(mappedBy = "medicos")
    private List<Paciente> pacientes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public List<Paciente> getPacientes() { return pacientes; }
    public void setPacientes(List<Paciente> pacientes) { this.pacientes = pacientes; }
}