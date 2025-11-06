package com.daniel.Sistema_de_Administracion_del_Personal.service.Impl;

import com.daniel.Sistema_de_Administracion_del_Personal.dto.EmpleadoDTO;
import com.daniel.Sistema_de_Administracion_del_Personal.model.Empleado;
import com.daniel.Sistema_de_Administracion_del_Personal.repository.AreaRepository;
import com.daniel.Sistema_de_Administracion_del_Personal.repository.CargoRepository;
import com.daniel.Sistema_de_Administracion_del_Personal.repository.EmpleadoRepository;
import com.daniel.Sistema_de_Administracion_del_Personal.service.IAreaService;
import com.daniel.Sistema_de_Administracion_del_Personal.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public List<EmpleadoDTO> listAll() {
        return empleadoRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO findById(Long id) {
        return empleadoRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public EmpleadoDTO save(EmpleadoDTO dto) {
        Empleado empleado = mapToEntity(dto);
        Empleado nuevo = empleadoRepository.save(empleado);
        return mapToDTO(nuevo);
    }

    @Override
    public EmpleadoDTO update(Long id, EmpleadoDTO dto) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado == null) return null;
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setDni(dto.getDni());
        empleado.setEmail(dto.getEmail());
        empleado.setSalario(dto.getSalario());
        empleado.setArea(areaRepository.findById(dto.getIdArea()).orElse(null));
        empleado.setCargo(cargoRepository.findById(dto.getIdCargo()).orElse(null));

        Empleado actualizado = empleadoRepository.save(empleado);
        return mapToDTO(actualizado);
    }

    @Override
    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }

    //mapeos de dtos

    private EmpleadoDTO mapToDTO (Empleado e){
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setApellido(e.getApellido());
        dto.setDni(e.getDni());
        dto.setEmail(e.getEmail());
        dto.setSalario(e.getSalario());
        dto.setIdArea(e.getArea() != null ? e.getArea().getId() : null);
        dto.setIdCargo(e.getCargo() != null ? e.getCargo().getId() : null);
        return dto;
    }

    private Empleado mapToEntity (EmpleadoDTO dto){
        Empleado e = new Empleado();
        e.setId(dto.getId());
        e.setNombre(dto.getNombre());
        e.setApellido(dto.getApellido());
        e.setDni(dto.getDni());
        e.setEmail(dto.getEmail());
        e.setSalario(dto.getSalario());
        e.setArea(areaRepository.findById(dto.getIdArea()).orElse(null));
        e.setCargo(cargoRepository.findById(dto.getIdCargo()).orElse(null));
        return e;
    }
}
