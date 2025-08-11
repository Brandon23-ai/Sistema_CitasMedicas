package com.brandon.citasmedicas.repository;

import com.brandon.citasmedicas.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    Optional<Hospital> findByNombre(String nombre);
}
