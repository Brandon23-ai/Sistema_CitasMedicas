package com.brandon.citasmedicas.repository;

import com.brandon.citasmedicas.model.Cita;
import com.brandon.citasmedicas.model.Doctor;
import com.brandon.citasmedicas.model.Hospital;
import com.brandon.citasmedicas.model.Paciente;
import com.brandon.citasmedicas.model.enums.EstadoCita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    //Buscar por doctor y fecha/hora exacta (para validar conflictos)
    Optional<Cita> findByDoctorAndFechaHora(Doctor doctor, LocalDateTime fechaHora);

    //Buscar cita por paciente y fecha/hora exacta
    Optional<Cita> findByPacienteAndFechaHora(Paciente paciente, LocalDateTime fechaHora);

    //Listar citas por estado.
    List<Cita> findByEstado(EstadoCita estado);

    //Listar citas por hospital
    List<Cita> findByHospital(Hospital hospital);

    //Listar citas por doctor
    List<Cita> findByDoctor(Doctor doctor);

    //Listar citas por paciente
    List<Cita> findByPaciente(Paciente paciente);

    // Buscar citas entre rangos de fecha y estado
    @Query("SELECT c FROM Cita c WHERE c.fechaHora BETWEEN ?1 AND ?2 AND c.estado = ?3")
    List<Cita> findCitasByFechaBetweenAndEstado(LocalDateTime desde, LocalDateTime hasta, EstadoCita estado);

}
