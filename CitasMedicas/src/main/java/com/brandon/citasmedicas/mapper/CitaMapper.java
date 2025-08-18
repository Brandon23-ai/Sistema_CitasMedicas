package com.brandon.citasmedicas.mapper;

import com.brandon.citasmedicas.dto.CitaDTO;
import com.brandon.citasmedicas.model.Cita;
import com.brandon.citasmedicas.model.Doctor;
import com.brandon.citasmedicas.model.Hospital;
import com.brandon.citasmedicas.model.Paciente;

public class CitaMapper {
    public static CitaDTO toDTO(Cita cita){
        if (cita == null){
            return null;
        }

        CitaDTO dto = new CitaDTO();
        dto.setId(cita.getId());
        dto.setNombrePaciente(cita.getPaciente().getNombre());
        dto.setNombreDoctor(cita.getDoctor().getNombre());
        dto.setNombreHospital(cita.getHospital().getNombre());
        dto.setEstado(cita.getEstado());
        dto.setFechaHora(cita.getFechaHora());

        dto.setPacienteId(cita.getPaciente().getId());
        dto.setDoctorId(cita.getDoctor().getId());
        dto.setHospitalId(cita.getHospital().getId());

        return dto;
    }

    public static Cita toEntity(CitaDTO dto, Paciente paciente, Doctor doctor, Hospital hospital){
        if (dto == null){
            return null;
        }

        Cita cita = new Cita();
        cita.setId(dto.getId());
        cita.setFechaHora( dto.getFechaHora());

        if (dto.getEstado() != null){
            cita.setEstado(dto.getEstado());
        }

        cita.setPaciente(paciente);
        cita.setDoctor(doctor);
        cita.setHospital(hospital);

        return cita;
    }

    public static void updateEntityFromDTO(CitaDTO dto, Cita cita) {
        if (dto == null || cita == null) {
            return;
        }
        // Actualizamos los campos que pueden cambiar
        cita.setFechaHora(dto.getFechaHora());
        cita.setEstado(dto.getEstado());
        // Relaciones las debes actualizar en el servicio porque necesitan buscar las entidades correspondientes
    }

}
