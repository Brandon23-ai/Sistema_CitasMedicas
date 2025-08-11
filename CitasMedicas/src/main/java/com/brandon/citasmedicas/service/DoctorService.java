package com.brandon.citasmedicas.service;

import com.brandon.citasmedicas.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {

    DoctorDTO crear (DoctorDTO dto);
    DoctorDTO actualizar (Long id, DoctorDTO dto);
    void eliminar (Long id);
    DoctorDTO obtenerPorId(Long id);
    List<DoctorDTO> obtenerTodos();

}
