package com.brandon.citasmedicas.repository;

import com.brandon.citasmedicas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Optional<Paciente> findByCorreo(String correo);
}
