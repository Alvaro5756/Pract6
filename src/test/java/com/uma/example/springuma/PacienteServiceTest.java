package com.uma.example.springuma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uma.example.springuma.model.Paciente;
import com.uma.example.springuma.model.PacienteService;
import com.uma.example.springuma.model.RepositoryPaciente;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @Mock
    RepositoryPaciente repositoryPaciente;

    @InjectMocks
    private PacienteService pacienteService;

    @Test
    @DisplayName("Comprueba que se pueden obtener todos los pacientes (lista vacía)")
    public void obtenerTodos_noPacientes_obtieneListaVacia() {
        // Arrange
        when(repositoryPaciente.findAll()).thenReturn(List.of());

        // Act
        List<Paciente> result = pacienteService.obtenerTodos();

        // Assert
        assertEquals(0, result.size());
        verify(repositoryPaciente).findAll();
    }

    @Test
    @DisplayName("Comprueba que devuelve varios pacientes correctamente")
    public void obtenerTodos_variosPacientes_obtieneListaNoVacia() {
        // Arrange
        Paciente p1 = new Paciente("Antonio Lobato", "AntonioLobato@uma.es", "123", "Sano");
        Paciente p2 = new Paciente("Ana", "ana@uma.es", "456", "Gripe");
        when(repositoryPaciente.findAll()).thenReturn(Arrays.asList(p1, p2));

        // Act
        List<Paciente> result = pacienteService.obtenerTodos();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Antonio Lobato", result.get(0).getNombre());
        verify(repositoryPaciente).findAll();
    }

    @Test
    @DisplayName("Comprueba que se puede obtener un paciente por ID")
    public void obtenerPorId_pacienteExistente_pacienteObtenido() {
        // Arrange
        Paciente paciente = new Paciente("Juan", "juan@uma.es", "123", "Sano");
        paciente.setId(1L);
        when(repositoryPaciente.findById(1L)).thenReturn(Optional.of(paciente));

        // Act
        Optional<Paciente> result = pacienteService.obtenerPorId(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(paciente, result.get());
        verify(repositoryPaciente).findById(1L);
    }

    @Test
    @DisplayName("Comprueba que se guarda un paciente correctamente")
    public void guardarPaciente_pacienteNuevo_pacienteGuardado() {
        // Arrange
        Paciente paciente = new Paciente("Nuevo", "nuevo@uma.es", "000", "Historial");
        // Nota: Tu servicio usa saveAndFlush, así que debemos mockear ese método
        when(repositoryPaciente.saveAndFlush(paciente)).thenReturn(paciente);

        // Act
        Paciente result = pacienteService.guardarPaciente(paciente);

        // Assert
        assertEquals(paciente, result);
        verify(repositoryPaciente).saveAndFlush(paciente);
    }

    @Test
    @DisplayName("Comprueba que se actualiza un paciente correctamente")
    public void actualizarPaciente_pacienteExistente_pacienteActualizado() {
        // Arrange
        Paciente paciente = new Paciente("Juan", "juan@uma.es", "123", "Sano");
        paciente.setId(1L);
        // Tu servicio usa save para actualizar
        when(repositoryPaciente.save(paciente)).thenReturn(paciente);

        // Act
        Paciente result = pacienteService.actualizarPaciente(paciente);

        // Assert
        assertEquals(paciente, result);
        verify(repositoryPaciente).save(paciente);
    }

    @Test
    @DisplayName("Comprueba que se elimina un paciente por ID correctamente")
    public void eliminarPaciente_idExistente_eliminaCorrectamente() {
        // Arrange
        Long id = 1L;

        // Act
        pacienteService.eliminarPaciente(id);

        // Assert
        verify(repositoryPaciente).deleteById(id);
    }
}