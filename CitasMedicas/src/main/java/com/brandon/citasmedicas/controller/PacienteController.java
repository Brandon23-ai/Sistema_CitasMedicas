package com.brandon.citasmedicas.controller;

import com.brandon.citasmedicas.dto.PacienteDTO;
import com.brandon.citasmedicas.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    @PostMapping
    public PacienteDTO crearPaciente(@RequestBody PacienteDTO dto) {
        return pacienteService.crear(dto);
    }

    @PutMapping("/{id}")
    public PacienteDTO actualizarPaciente(@PathVariable Long id, @RequestBody PacienteDTO dto) {
        return pacienteService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminar(id);
    }

    @GetMapping("/{id}")
    public PacienteDTO obtenerPacientePorId(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id);
    }

    @GetMapping
    public List<PacienteDTO> listarPacientes() {
        return pacienteService.obtenerTodos();
    }

}
