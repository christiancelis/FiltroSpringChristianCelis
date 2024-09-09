package com.campusbike.filtro.bicicletas.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.filtro.bicicletas.application.IBicicleta;
import com.campusbike.filtro.bicicletas.domain.Bicicletas;

@Service
public class BicicletaServiceImp implements IBicicleta {

    @Autowired
    private BicicletaRepository bicicletaRepository;

    @Override
    public List<Bicicletas> getAllBicicletas(){
        return bicicletaRepository.findAll();
    }


    @Override
    public Bicicletas getBicicletaById(Long id) {
        Optional <Bicicletas> bici = bicicletaRepository.findById(id);
        if(bici.isPresent()){
            return  bici.get();
        }

        return null;
    }

    @Override
    public Bicicletas createBicicleta(Bicicletas bicicletas) {
        return bicicletaRepository.save(bicicletas);
    }


    @Override
    public Bicicletas deleteBicicletaById(Long id) {
        Optional <Bicicletas> bici = bicicletaRepository.findById(id);
        if(bici.isPresent()){
            bicicletaRepository.deleteById(id);
            return bici.get();
        }
        return null;
        
    }

    @Override
    public Bicicletas updateBicicletas(Long id, Bicicletas bicicletas) {
        if(bicicletaRepository.findById(id).isPresent()){
            return bicicletaRepository.save(bicicletas);
        }

        return null;

    }

}
