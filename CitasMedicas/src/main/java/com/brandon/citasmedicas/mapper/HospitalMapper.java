package com.brandon.citasmedicas.mapper;

import com.brandon.citasmedicas.dto.HospitalDTO;
import com.brandon.citasmedicas.model.Hospital;

public class HospitalMapper {

    public static HospitalDTO toDTO(Hospital hospital){
        if (hospital == null){
            return null;
        }

        HospitalDTO dto = new HospitalDTO();
        dto.setId(hospital.getId());
        dto.setNombre(hospital.getNombre());
        dto.setDireccion(hospital.getDireccion());

        return dto;
    }

    public static Hospital toEntity(HospitalDTO dto){
        if (dto == null){
            return null;
        }

        Hospital hospital = new Hospital();
        hospital.setId(dto.getId());
        hospital.setNombre(dto.getNombre());
        hospital.setDireccion(dto.getDireccion());

        return hospital;
    }



}
