package com.campusbike.filtro.marca.application;

import java.util.List;

import com.campusbike.filtro.marca.domain.Marca;

public interface IMarca {
     Marca createMarca(Marca marca);
    List<Marca> getAllMarcas();
    Marca getMarcaById(Long id);
}
