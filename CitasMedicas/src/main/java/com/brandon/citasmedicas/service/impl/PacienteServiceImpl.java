package com.brandon.citasmedicas.service.impl;

import com.brandon.citasmedicas.dto.PacienteDTO;
import com.brandon.citasmedicas.mapper.PacienteMapper;
import com.brandon.citasmedicas.model.Paciente;
import com.brandon.citasmedicas.repository.PacienteRepository;
import com.brandon.citasmedicas.service.PacienteService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteDTO crear(PacienteDTO dto) {
        Paciente paciente = PacienteMapper.toEntity(dto);
        Paciente guardado = pacienteRepository.save(paciente);
        return PacienteMapper.toDTO(guardado);
    }

    @Override
    public PacienteDTO actualizar(Long id, PacienteDTO dto) {
        return pacienteRepository.findById(id).map(pacienteExistente -> {
            pacienteExistente.setNombre(dto.getNombre());
            pacienteExistente.setCorreo(dto.getCorreo());
            return PacienteMapper.toDTO(pacienteRepository.save(pacienteExistente));
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO obtenerPorId(Long id) {
        return pacienteRepository.findById(id)
                .map(PacienteMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<PacienteDTO> obtenerTodos() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
