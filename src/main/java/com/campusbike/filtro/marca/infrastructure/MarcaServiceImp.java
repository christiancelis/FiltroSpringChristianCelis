package com.campusbike.filtro.marca.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.filtro.marca.application.IMarca;
import com.campusbike.filtro.marca.domain.Marca;
@Service
public class MarcaServiceImp implements IMarca{

      @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Marca createMarca(Marca marca) {
        return  marcaRepository.save(marca);
    }

    @Override
    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca getMarcaById(Long id) {
      Optional <Marca> marca = marcaRepository.findById(id);
        if(marca.isPresent()){
            return marca.get();
        }

        return null;
    }

}
