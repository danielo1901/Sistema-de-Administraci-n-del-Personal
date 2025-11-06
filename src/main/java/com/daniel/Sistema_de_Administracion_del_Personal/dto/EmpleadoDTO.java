package com.daniel.Sistema_de_Administracion_del_Personal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private double salario;
    private Long idArea;
    private Long idCargo;
}
