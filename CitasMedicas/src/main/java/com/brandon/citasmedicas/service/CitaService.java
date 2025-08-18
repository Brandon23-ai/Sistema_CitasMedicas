package com.brandon.citasmedicas.service;

import com.brandon.citasmedicas.dto.CitaDTO;

import java.util.List;

public interface CitaService {

    List<CitaDTO> listarCitas();
    CitaDTO obtenerCitaPorId(Long id);
    CitaDTO crearCita(CitaDTO citaDTO);
    CitaDTO actualizarCita(Long id, CitaDTO citaDTO);
    void eliminarCita(Long id);

    //Manejo de estados
    CitaDTO confirmarCita(Long id);
    CitaDTO cancelarCita (Long id);
    CitaDTO finalizarCita(Long id);

}
