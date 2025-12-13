package com.uma.example.springuma.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private RepositoryPaciente pacienteRepository;

    // Crear un nuevo paciente
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.saveAndFlush(paciente);
    }

    // Leer todos los pacientes (ConsultarDatos)
    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    // Leer uno por ID
    public Optional<Paciente> obtenerPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    // Actualizar (Equivalente a ModificarPerfil en tu diagrama)
    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Borrar
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}