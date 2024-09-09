package com.campusbike.filtro.modelo.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.filtro.modelo.application.IModelo;
import com.campusbike.filtro.modelo.domain.Modelo;

@Service
public class ModeloServiceImp implements IModelo {


    @Autowired
    private ModeloRepository modeloRepository;


    @Override
    public Modelo createModel(Modelo modelo) {
        return  modeloRepository.save(modelo);
    }

    @Override
    public List<Modelo> getAllModels() {
        return modeloRepository.findAll();
    }

    @Override
    public Modelo getModelById(Long id) {
        Optional <Modelo> modelo = modeloRepository.findById(id);
        if(modelo.isPresent()){
            return modelo.get();
        }

        return null;
    }

 
}
