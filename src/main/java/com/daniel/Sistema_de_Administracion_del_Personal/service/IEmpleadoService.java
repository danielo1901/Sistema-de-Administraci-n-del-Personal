package com.daniel.Sistema_de_Administracion_del_Personal.service;

import com.daniel.Sistema_de_Administracion_del_Personal.dto.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoDTO> listAll();
    EmpleadoDTO findById(Long id);
    EmpleadoDTO save(EmpleadoDTO dto);
    EmpleadoDTO update(Long id, EmpleadoDTO dto);
    void deleteById(Long id);
}
