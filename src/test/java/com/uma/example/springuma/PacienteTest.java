package com.uma.example.springuma;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.uma.example.springuma.model.Paciente;

public class PacienteTest {

    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        paciente = new Paciente();
    }

    @Test
    @DisplayName("Comprueba que el constructor con parámetros crea el objeto correctamente")
    public void constructor_parametros_Correcto() {
        // Arrange
        String nombre = "Pepe Viyuela";
        String email = "pepe@uma.es";
        String contrasena = "1234";
        String historial = "Pies muy peludos";

        // Act
        Paciente pacienteParametros = new Paciente(nombre, email, contrasena, historial);

        // Assert
        assertEquals(nombre, pacienteParametros.getNombre());
        assertEquals(email, pacienteParametros.getEmail());
        assertEquals(contrasena, pacienteParametros.getContrasena());
        assertEquals(historial, pacienteParametros.getHistorialClinico());
    }

    @Test
    @DisplayName("Comprueba que el ID se asigna y obtiene correctamente")
    public void id_getId_Correcto() {
        // Arrange
        Long id = 5L;
        paciente.setId(id);

        // Act
        Long idObtenido = paciente.getId();

        // Assert
        assertEquals(id, idObtenido);
    }

    @Test
    @DisplayName("Comprueba que el nombre se asigna y obtiene correctamente")
    public void nombre_getNombre_Correcto() {
        // Arrange
        String nombre = "Maria García";
        paciente.setNombre(nombre);

        // Act
        String nombreObtenido = paciente.getNombre();

        // Assert
        assertEquals(nombre, nombreObtenido);
    }

    @Test
    @DisplayName("Comprueba que el email se asigna y obtiene correctamente")
    public void email_getEmail_Correcto() {
        // Arrange
        String email = "maria@test.com";
        paciente.setEmail(email);

        // Act
        String emailObtenido = paciente.getEmail();

        // Assert
        assertEquals(email, emailObtenido);
    }

    @Test
    @DisplayName("Comprueba que la contraseña se asigna y obtiene correctamente")
    public void contrasena_getContrasena_Correcto() {
        // Arrange
        String pass = "secreta123";
        paciente.setContrasena(pass);

        // Act
        String passObtenida = paciente.getContrasena();

        // Assert
        assertEquals(pass, passObtenida);
    }

    @Test
    @DisplayName("Comprueba que el historial clínico se asigna y obtiene correctamente")
    public void historial_getHistorial_Correcto() {
        // Arrange
        String historial = "Gripe en 2020";
        paciente.setHistorialClinico(historial);

        // Act
        String historialObtenido = paciente.getHistorialClinico();

        // Assert
        assertEquals(historial, historialObtenido);
    }

    @Test
    @DisplayName("Comprueba que el ID del médico asignado se gestiona correctamente")
    public void idMedico_getIdMedico_Correcto() {
        // Arrange
        String idMedico = "MED-001";
        paciente.setIdMedicoAsignado(idMedico);

        // Act
        String idMedicoObtenido = paciente.getIdMedicoAsignado();

        // Assert
        assertEquals(idMedico, idMedicoObtenido);
    }
}