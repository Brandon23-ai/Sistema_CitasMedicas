package com.brandon.citasmedicas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;

    @ManyToMany(mappedBy = "hospitales")
    private List<Doctor> doctores;

    @OneToMany(mappedBy = "hospital")
    private List<Cita> citas;
}
