package com.campusbike.filtro.bicicletas.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BicicletaDTO {

    private double precio;
    private int stock;
    private Long idModelo;
    private Long idMarca;

}
