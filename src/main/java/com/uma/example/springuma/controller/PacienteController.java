package com.uma.example.springuma.controller;
import com.uma.example.springuma.model.Paciente;
import com.uma.example.springuma.model.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // GET: Obtener lista de pacientes
    @GetMapping("/api/pacientes")
    public List<Paciente> listarPacientes() {
        return pacienteService.obtenerTodos();
    }

    // POST: Crear un paciente (Registro)
    @PostMapping("/api/pacientes")
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardarPaciente(paciente);
    }

    // PUT: Actualizar datos de un paciente por ID
    @PutMapping("/api/pacientes")
    public Paciente actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        paciente.setId(id); // Asegurar que actualizamos el ID correcto
        return pacienteService.actualizarPaciente(paciente);
    }

    // DELETE: Eliminar un paciente
    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
    }
    
    // GET: Ver detalle de un solo paciente
    @GetMapping("/{id}")
    public Paciente verPaciente(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id).orElse(null);
    }
}