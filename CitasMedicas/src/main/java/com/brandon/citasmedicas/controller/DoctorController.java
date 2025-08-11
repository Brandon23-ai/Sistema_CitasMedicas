package com.brandon.citasmedicas.controller;

import com.brandon.citasmedicas.dto.DoctorDTO;
import com.brandon.citasmedicas.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public DoctorDTO crearDoctor(@RequestBody DoctorDTO dto) {
        return doctorService.crear(dto);
    }

    @PutMapping("/{id}")
    public DoctorDTO actualizarDoctor(@PathVariable Long id, @RequestBody DoctorDTO dto) {
        return doctorService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarDoctor(@PathVariable Long id) {
        doctorService.eliminar(id);
    }

    @GetMapping("/{id}")
    public DoctorDTO obtenerDoctorPorId(@PathVariable Long id) {
        return doctorService.obtenerPorId(id);
    }

    @GetMapping
    public List<DoctorDTO> obtenerTodosLosDoctores() {
        return doctorService.obtenerTodos();
    }
}
