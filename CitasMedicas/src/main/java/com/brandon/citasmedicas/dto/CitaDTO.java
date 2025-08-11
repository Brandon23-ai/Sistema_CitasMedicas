package com.brandon.citasmedicas.dto;

import com.brandon.citasmedicas.model.enums.EstadoCita;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class CitaDTO {
    private Long id;
    private LocalDateTime fechaHora;
    private EstadoCita estado;

    private String nombrePaciente;
    private String nombreDoctor;
    private String nombreHospital;

    private Long pacienteId;
    private Long doctorId;
    private Long hospitalId;

}
