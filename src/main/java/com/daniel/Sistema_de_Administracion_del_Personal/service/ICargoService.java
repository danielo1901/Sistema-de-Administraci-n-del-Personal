package com.daniel.Sistema_de_Administracion_del_Personal.service;

import com.daniel.Sistema_de_Administracion_del_Personal.dto.AreaDTO;
import com.daniel.Sistema_de_Administracion_del_Personal.dto.CargoDTO;

import java.util.List;

public interface ICargoService {
    List<CargoDTO> list();
    CargoDTO save(CargoDTO cargoDTO);
    void deleteById(Long id);
}
