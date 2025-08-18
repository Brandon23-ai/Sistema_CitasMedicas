package com.brandon.citasmedicas.dto;

import com.brandon.citasmedicas.model.enums.EstadoCita;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class CitaDTO {
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaHora;

    private EstadoCita estado = null;

    private String nombrePaciente;
    private String nombreDoctor;
    private String nombreHospital;

    private Long pacienteId;
    private Long doctorId;
    private Long hospitalId;

}
