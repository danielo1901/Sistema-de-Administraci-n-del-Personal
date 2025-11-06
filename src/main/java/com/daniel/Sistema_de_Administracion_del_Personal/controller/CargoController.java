package com.daniel.Sistema_de_Administracion_del_Personal.controller;


import com.daniel.Sistema_de_Administracion_del_Personal.dto.CargoDTO;

import com.daniel.Sistema_de_Administracion_del_Personal.service.ICargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    @Autowired
    private ICargoService cargoService;

    @GetMapping
    public List<CargoDTO> listar(){
        return cargoService.list();
    }

    @PostMapping
    public CargoDTO registrar(@RequestBody CargoDTO cargoDTO){
        return cargoService.save(cargoDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id){
        cargoService.deleteById(id);
    }
}
