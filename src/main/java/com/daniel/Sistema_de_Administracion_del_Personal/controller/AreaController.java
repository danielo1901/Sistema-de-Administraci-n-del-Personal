package com.daniel.Sistema_de_Administracion_del_Personal.controller;

import com.daniel.Sistema_de_Administracion_del_Personal.dto.AreaDTO;
import com.daniel.Sistema_de_Administracion_del_Personal.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @GetMapping
    public List<AreaDTO> listar(){
        return areaService.list();
    }

    @PostMapping
    public AreaDTO registrar(@RequestBody AreaDTO areaDTO){
        return areaService.save(areaDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id){
        areaService.deleteById(id);
    }
}
