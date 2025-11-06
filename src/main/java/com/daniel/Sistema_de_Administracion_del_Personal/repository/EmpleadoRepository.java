package com.daniel.Sistema_de_Administracion_del_Personal.repository;

import com.daniel.Sistema_de_Administracion_del_Personal.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
}
