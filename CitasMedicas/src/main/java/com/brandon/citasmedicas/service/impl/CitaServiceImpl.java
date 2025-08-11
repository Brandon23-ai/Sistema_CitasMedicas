package com.brandon.citasmedicas.service.impl;

import com.brandon.citasmedicas.dto.CitaDTO;
import com.brandon.citasmedicas.mapper.CitaMapper;
import com.brandon.citasmedicas.model.Cita;
import com.brandon.citasmedicas.model.Doctor;
import com.brandon.citasmedicas.model.Hospital;
import com.brandon.citasmedicas.model.Paciente;
import com.brandon.citasmedicas.repository.CitaRepository;
import com.brandon.citasmedicas.repository.DoctorRepository;
import com.brandon.citasmedicas.repository.HospitalRepository;
import com.brandon.citasmedicas.repository.PacienteRepository;
import com.brandon.citasmedicas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;

    @Autowired
    public CitaServiceImpl(CitaRepository citaRepository,
                           PacienteRepository pacienteRepository,
                           DoctorRepository doctorRepository,
                           HospitalRepository hospitalRepository) {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public CitaDTO crearCita (CitaDTO dto){
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(()-> new RuntimeException("Paciente no encontrado"));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(()-> new RuntimeException("Doctor no encontrado"));

        Hospital hospital = hospitalRepository.findById(dto.getHospitalId())
                .orElseThrow(()-> new RuntimeException("Hospital no encontrado"));

        Cita cita = CitaMapper.toEntity(dto, paciente, doctor, hospital);
        Cita citaGuardada = citaRepository.save(cita);
        return CitaMapper.toDTO(citaGuardada);
    }

    @Override
    public CitaDTO actualizarCita(Long id, CitaDTO dto) {
        Cita citaExistente = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        // Actualizar campos simples con el mapper
        CitaMapper.updateEntityFromDTO(dto, citaExistente);

        // Actualizar relaciones si vienen en el DTO
        if (dto.getPacienteId() != null) {
            Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                    .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
            citaExistente.setPaciente(paciente);
        }
        if (dto.getDoctorId() != null) {
            Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
            citaExistente.setDoctor(doctor);
        }
        if (dto.getHospitalId() != null) {
            Hospital hospital = hospitalRepository.findById(dto.getHospitalId())
                    .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
            citaExistente.setHospital(hospital);
        }

        citaRepository.save(citaExistente);
        return CitaMapper.toDTO(citaExistente);
    }

    @Override
    public CitaDTO obtenerCitaPorId(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return CitaMapper.toDTO(cita);
    }

    @Override
    public void eliminarCita(Long id) {
        if (!citaRepository.existsById(id)) {
            throw new RuntimeException("Cita no encontrada");
        }
        citaRepository.deleteById(id);
    }

    @Override
    public List<CitaDTO> listarCitas() {
        List<Cita> citas = citaRepository.findAll();
        return citas.stream()
                .map(CitaMapper::toDTO)
                .collect(Collectors.toList());
    }



}
