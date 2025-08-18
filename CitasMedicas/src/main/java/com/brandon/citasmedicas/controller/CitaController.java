package com.brandon.citasmedicas.controller;


import com.brandon.citasmedicas.dto.CitaDTO;
import com.brandon.citasmedicas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity<List<CitaDTO>> listarCitas() {
        List<CitaDTO> citas = citaService.listarCitas();
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> obtenerCitaPorId(@PathVariable Long id) {
        CitaDTO cita = citaService.obtenerCitaPorId(id);
        return ResponseEntity.ok(cita);
    }

    @PostMapping
    public ResponseEntity<CitaDTO> crearCita(@RequestBody CitaDTO citaDTO) {
        CitaDTO nuevaCita = citaService.crearCita(citaDTO);
        return ResponseEntity.ok(nuevaCita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> actualizarCita(@PathVariable Long id, @RequestBody CitaDTO citaDTO) {
        CitaDTO citaActualizada = citaService.actualizarCita(id, citaDTO);
        return ResponseEntity.ok(citaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }

    //Manejo de estados
    @PutMapping("/{id}/confirmar")
    public ResponseEntity<CitaDTO> confirmar(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.confirmarCita(id));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<CitaDTO> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.cancelarCita(id));
    }

    @PutMapping("/{id}/finalizar")
    public ResponseEntity<CitaDTO> finalizar(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.finalizarCita(id));
    }




}
