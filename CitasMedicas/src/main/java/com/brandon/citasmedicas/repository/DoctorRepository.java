package com.brandon.citasmedicas.repository;

import com.brandon.citasmedicas.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findByNombreContainingIgnoreCase(String nombre);

    List<Doctor> findByEspecialidad(String especialidad);

    //Buscar doctores por hospital (Id)
    List<Doctor> findByHospitales_Id(Long hospitalesId);
}
