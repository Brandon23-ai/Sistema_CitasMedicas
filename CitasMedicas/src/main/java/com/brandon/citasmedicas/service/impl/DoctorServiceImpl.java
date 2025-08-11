package com.brandon.citasmedicas.service.impl;

import com.brandon.citasmedicas.dto.DoctorDTO;
import com.brandon.citasmedicas.mapper.DoctorMapper;
import com.brandon.citasmedicas.model.Doctor;
import com.brandon.citasmedicas.repository.DoctorRepository;
import com.brandon.citasmedicas.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @Override
    public DoctorDTO crear(DoctorDTO dto) {
        Doctor doctor = DoctorMapper.toEntity(dto);
        Doctor guardado = doctorRepository.save(doctor);
        return DoctorMapper.toDTO(guardado);
    }

    @Override
    public DoctorDTO actualizar(Long id, DoctorDTO dto) {
        return doctorRepository.findById(id).map(doctorExistente -> {
            doctorExistente.setNombre(dto.getNombre());
            doctorExistente.setEspecialidad(dto.getEspecialidad());
            return DoctorMapper.toDTO(doctorRepository.save(doctorExistente));
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorDTO obtenerPorId(Long id) {
        return doctorRepository.findById(id)
                .map(DoctorMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<DoctorDTO> obtenerTodos() {
        return doctorRepository.findAll().stream()
                .map(DoctorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
