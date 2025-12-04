package com.uma.example.springuma.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos heredados de USUARIO 
    private String nombre;
    private String email;
    private String contrasena;

    // Atributos específicos de PACIENTE 
    @Column(length = 1000) 
    private String historialClinico;

    private String idMedicoAsignado; // Relación con médico

    public Paciente() {
    }

    public Paciente(String nombre, String email, String contrasena, String historialClinico) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.historialClinico = historialClinico;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    
    public String getHistorialClinico() { return historialClinico; }
    public void setHistorialClinico(String historialClinico) { this.historialClinico = historialClinico; }

    public String getIdMedicoAsignado() { return idMedicoAsignado; }
    public void setIdMedicoAsignado(String idMedicoAsignado) { this.idMedicoAsignado = idMedicoAsignado; }
}