package com.brandon.citasmedicas.service.impl;

import com.brandon.citasmedicas.dto.HospitalDTO;
import com.brandon.citasmedicas.mapper.HospitalMapper;
import com.brandon.citasmedicas.model.Hospital;
import com.brandon.citasmedicas.repository.HospitalRepository;
import com.brandon.citasmedicas.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public HospitalDTO crear(HospitalDTO dto){
        Hospital hospital = HospitalMapper.toEntity(dto);
        Hospital guardado = hospitalRepository.save(hospital);
        return HospitalMapper.toDTO(guardado);
    }

    @Override
    public HospitalDTO actualizar(Long id, HospitalDTO dto){
        return hospitalRepository.findById(id).map(hospitalExistente ->{
            hospitalExistente.setNombre(dto.getNombre());
            hospitalExistente.setDireccion(dto.getDireccion());
            return HospitalMapper.toDTO(hospitalRepository.save(hospitalExistente));
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public HospitalDTO obtenerPorId(Long id) {
        return hospitalRepository.findById(id)
                .map(HospitalMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<HospitalDTO> obtenerTodos() {
        return hospitalRepository.findAll()
                .stream()
                .map(HospitalMapper::toDTO)
                .collect(Collectors.toList());
    }

}
