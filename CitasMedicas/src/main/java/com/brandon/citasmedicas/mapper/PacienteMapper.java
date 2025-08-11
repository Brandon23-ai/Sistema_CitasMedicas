package com.brandon.citasmedicas.mapper;

import com.brandon.citasmedicas.dto.PacienteDTO;
import com.brandon.citasmedicas.model.Paciente;

public class PacienteMapper {

    public static PacienteDTO toDTO(Paciente paciente){
        if (paciente == null){
            return new PacienteDTO();
        }

        PacienteDTO dto = new PacienteDTO();
        dto.setId(paciente.getId());
        dto.setNombre(paciente.getNombre());
        dto.setCorreo(paciente.getCorreo());

        return dto;
    }

    public static Paciente toEntity(PacienteDTO dto){
        if (dto == null){
            return new Paciente();
        }

        Paciente paciente = new Paciente();
        paciente.setId(dto.getId());
        paciente.setNombre(dto.getNombre());
        paciente.setCorreo(dto.getCorreo());

        return  paciente;
    }


}
