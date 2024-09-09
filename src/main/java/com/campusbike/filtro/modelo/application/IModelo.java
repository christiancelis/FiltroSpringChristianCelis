package com.campusbike.filtro.modelo.application;

import java.util.List;

import com.campusbike.filtro.modelo.domain.Modelo;

public interface IModelo {
    Modelo createModel(Modelo modelo);
    List<Modelo> getAllModels();
    Modelo getModelById(Long id);
}
