package com.daniel.Sistema_de_Administracion_del_Personal.repository;


import com.daniel.Sistema_de_Administracion_del_Personal.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository  extends JpaRepository<Cargo,Long> {
}
