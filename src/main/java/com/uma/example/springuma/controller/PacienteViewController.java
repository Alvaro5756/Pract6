package com.uma.example.springuma.controller;

import com.uma.example.springuma.model.Paciente;
import com.uma.example.springuma.model.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PacienteViewController {

    @Autowired
    private PacienteService pacienteService;

    // Listar pacientes 
    @GetMapping("/pacientes")
    public String listarPacientes(Model model) {
        // "cuentas" en el ejemplo del profe, aquí "pacientes"
        model.addAttribute("pacientes", pacienteService.obtenerTodos());
        return "paciente"; // Nombre del HTML en templates/paciente.html
    }

    // Formulario para crear nuevo paciente 
    @GetMapping("/pacientes/nuevo")
    public String crearPaciente(Model model) {
        // Pasamos un objeto vacío para el th:object
        model.addAttribute("paciente", new Paciente());
        return "paciente_detalle"; 
    }

    // Formulario  
    @GetMapping("/pacientes/editar/{id}")
    public String editarPaciente(@PathVariable Long id, Model model) {
        Optional<Paciente> pacienteOpt = pacienteService.obtenerPorId(id);
        if (pacienteOpt.isPresent()) {
            model.addAttribute("paciente", pacienteOpt.get());
            return "paciente_detalle";
        } else {
            return "redirect:/pacientes";
        }
    }

    // Guardar (POST) 
    @PostMapping("/pacientes/guardar")
    public String guardarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        // Vuestro servicio usa saveAndFlush, que sirve para crear y actualizar
        pacienteService.guardarPaciente(paciente);
        return "redirect:/pacientes";
    }

//Borrar    
    @GetMapping("/pacientes/borrar/{id}")
    public String borrarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return "redirect:/pacientes";
    }
}