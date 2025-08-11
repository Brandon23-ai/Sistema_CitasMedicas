package com.brandon.citasmedicas.service;

import com.brandon.citasmedicas.dto.PacienteDTO;

import java.util.List;

public interface PacienteService {

    PacienteDTO crear (PacienteDTO dto);
    PacienteDTO actualizar (Long id, PacienteDTO dto);
    void eliminar (Long id);
    PacienteDTO obtenerPorId (Long id);
    List<PacienteDTO> obtenerTodos();

}
