package com.campusbike.filtro.bicicletas.application;

import java.util.List;

import com.campusbike.filtro.bicicletas.domain.Bicicletas;

public interface IBicicleta {
    List<Bicicletas> getAllBicicletas();
    Bicicletas getBicicletaById(Long id);
    Bicicletas deleteBicicletaById(Long id);
    Bicicletas createBicicleta(Bicicletas bicicletas);
    Bicicletas updateBicicletas(Long id, Bicicletas bicicletas);
}
