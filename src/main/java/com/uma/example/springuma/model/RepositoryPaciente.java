package com.uma.example.springuma.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPaciente extends JpaRepository<Paciente, Long> {
    // Aquí Spring crea mágicamente el código para buscar, guardar y borrar.
}