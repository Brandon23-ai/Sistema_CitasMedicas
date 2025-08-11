package com.brandon.citasmedicas.controller;


import com.brandon.citasmedicas.dto.HospitalDTO;
import com.brandon.citasmedicas.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitales")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public HospitalDTO crear(@RequestBody HospitalDTO dto) {
        return hospitalService.crear(dto);
    }

    @PutMapping("/{id}")
    public HospitalDTO actualizar(@PathVariable Long id, @RequestBody HospitalDTO dto) {
        return hospitalService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        hospitalService.eliminar(id);
    }

    @GetMapping("/{id}")
    public HospitalDTO obtenerPorId(@PathVariable Long id) {
        return hospitalService.obtenerPorId(id);
    }

    @GetMapping
    public List<HospitalDTO> obtenerTodos() {
        return hospitalService.obtenerTodos();
    }
}
