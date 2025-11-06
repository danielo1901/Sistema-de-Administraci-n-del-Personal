package com.daniel.Sistema_de_Administracion_del_Personal.service.Impl;

import com.daniel.Sistema_de_Administracion_del_Personal.dto.AreaDTO;
import com.daniel.Sistema_de_Administracion_del_Personal.model.Area;
import com.daniel.Sistema_de_Administracion_del_Personal.repository.AreaRepository;
import com.daniel.Sistema_de_Administracion_del_Personal.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<AreaDTO> list() {
        return areaRepository.findAll().stream().map(
                area ->{
                    AreaDTO dto = new AreaDTO();
                    dto.setId(area.getId());
                    dto.setNombre(area.getNombre());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public AreaDTO save(AreaDTO areaDTO) {
        Area a = new Area();
        a.setNombre(areaDTO.getNombre());
        Area areasave = areaRepository.save(a);
        areaDTO.setId(areasave.getId());
        return areaDTO;
    }

    @Override
    public void deleteById(Long id) {
        areaRepository.deleteById(id);
    }
}
