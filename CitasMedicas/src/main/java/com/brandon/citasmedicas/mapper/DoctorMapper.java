package com.brandon.citasmedicas.mapper;

import com.brandon.citasmedicas.dto.DoctorDTO;
import com.brandon.citasmedicas.model.Doctor;

public class DoctorMapper {
    public static DoctorDTO toDTO(Doctor doctor){
        if (doctor == null){
            return null;
        }

        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setNombre(doctor.getNombre());
        dto.setEspecialidad(doctor.getEspecialidad());

        return dto;
    }

    public static Doctor toEntity(DoctorDTO dto){
        if (dto == null){
            return null;
        }

        Doctor doctor = new Doctor();
        doctor.setId(dto.getId());
        doctor.setNombre(dto.getNombre());
        doctor.setEspecialidad(dto.getEspecialidad());

        return doctor;
    }
}
