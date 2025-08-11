package com.brandon.citasmedicas.service;

import com.brandon.citasmedicas.dto.HospitalDTO;

import java.util.List;

public interface HospitalService {

    HospitalDTO crear (HospitalDTO dto);
    HospitalDTO actualizar (Long id, HospitalDTO dto);
    void eliminar (Long id);
    HospitalDTO obtenerPorId(Long id);
    List<HospitalDTO> obtenerTodos();

}
