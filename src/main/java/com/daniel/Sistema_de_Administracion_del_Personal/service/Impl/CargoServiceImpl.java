package com.daniel.Sistema_de_Administracion_del_Personal.service.Impl;

import com.daniel.Sistema_de_Administracion_del_Personal.dto.CargoDTO;
import com.daniel.Sistema_de_Administracion_del_Personal.model.Cargo;
import com.daniel.Sistema_de_Administracion_del_Personal.repository.CargoRepository;
import com.daniel.Sistema_de_Administracion_del_Personal.service.ICargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoServiceImpl implements ICargoService{

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public List<CargoDTO> list() {
        return cargoRepository.findAll().stream().map(
                cargo ->{
                    CargoDTO dto = new CargoDTO();
                    dto.setId(cargo.getId());
                    dto.setNombre(cargo.getNombre());
                    dto.setSalarioBase(cargo.getSalarioBase());
                    return dto;
                } ).collect(Collectors.toList());
    }

    @Override
    public CargoDTO save(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();
        cargo.setNombre(cargoDTO.getNombre());
        Cargo cargosave = cargoRepository.save(cargo);
        cargoDTO.setId(cargosave.getId());
        return cargoDTO;
    }

    @Override
    public void deleteById(Long id) {
        cargoRepository.deleteById(id);
    }
}
