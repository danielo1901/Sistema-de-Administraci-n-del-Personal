package com.daniel.Sistema_de_Administracion_del_Personal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CargoDTO {
    private Long id;
    private String nombre;
    private double salarioBase;
}
