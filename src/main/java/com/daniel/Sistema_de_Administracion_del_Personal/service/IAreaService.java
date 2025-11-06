package com.daniel.Sistema_de_Administracion_del_Personal.service;

import com.daniel.Sistema_de_Administracion_del_Personal.dto.AreaDTO;

import java.util.List;

public interface IAreaService {

    List<AreaDTO> list();
    AreaDTO save(AreaDTO areaDTO);
    void deleteById(Long id);
}
