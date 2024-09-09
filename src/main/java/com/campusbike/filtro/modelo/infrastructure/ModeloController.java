package com.campusbike.filtro.modelo.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusbike.filtro.modelo.domain.Modelo;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloServiceImp modeloServiceImp;



    @GetMapping("")
    public List<Modelo> getAllModels() {
        return modeloServiceImp.getAllModels();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getModelById(@PathVariable Long id) {
        if(modeloServiceImp.getModelById(id)!=null){
            return ResponseEntity.ok().body(modeloServiceImp.getModelById(id));
        }
        
        return ResponseEntity.status(404).build();
    }

    @PostMapping("")
    public Modelo createModel(@Valid @RequestBody Modelo modelo) {
        return modeloServiceImp.createModel(modelo);
    }
    
    
}
