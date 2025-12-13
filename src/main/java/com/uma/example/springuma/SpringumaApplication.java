package com.uma.example.springuma;

import com.uma.example.springuma.model.Paciente;
import com.uma.example.springuma.model.PacienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Clase principal de la aplicacion Spring Boot
@SpringBootApplication
public class SpringumaApplication {
	// Metodo principal que inicia la aplicacion Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(SpringumaApplication.class, args);
	}

	@Bean
	public CommandLineRunner seed(PacienteService pacienteService) {
		return args -> {
			if (pacienteService.obtenerTodos().isEmpty()) {
				pacienteService.guardarPaciente(new Paciente("Ana", "ana@example.com", "1234", "Sin historial"));
				pacienteService.guardarPaciente(new Paciente("Juan", "juan@example.com", "abcd", "Alergia a penicilina"));
			}
		};
	}

}
