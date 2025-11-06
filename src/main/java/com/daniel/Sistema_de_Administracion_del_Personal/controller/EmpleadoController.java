package com.daniel.Sistema_de_Administracion_del_Personal.controller;

import com.daniel.Sistema_de_Administracion_del_Personal.dto.EmpleadoDTO;
import com.daniel.Sistema_de_Administracion_del_Personal.model.Empleado;
import com.daniel.Sistema_de_Administracion_del_Personal.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping
    public List<EmpleadoDTO> listar(){
        return empleadoService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> buscarPorId(@PathVariable Long id){
        EmpleadoDTO empleado = empleadoService.findById(id);
        return empleado != null ? ResponseEntity.ok(empleado) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public EmpleadoDTO registrar(@RequestBody EmpleadoDTO dto){
        return empleadoService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizar(@PathVariable Long id,@RequestBody EmpleadoDTO dto){
        EmpleadoDTO empleadoActualizado = empleadoService.update(id,dto);
        return empleadoActualizado != null ? ResponseEntity.ok(empleadoActualizado) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        empleadoService.deleteById(id);
    }

}
