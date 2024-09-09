package com.campusbike.filtro.marca.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusbike.filtro.marca.domain.Marca;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {
     @Autowired
    private MarcaServiceImp marcaServiceImp;

    
    @GetMapping("")
    public List<Marca> getAllMarcas() {
        return marcaServiceImp.getAllMarcas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMarcaById(@PathVariable Long id) {
        if(marcaServiceImp.getMarcaById(id)!=null){
            return ResponseEntity.ok().body(marcaServiceImp.getMarcaById(id));
        }
        
        return ResponseEntity.status(404).build();
    }

    @PostMapping("")
    public Marca createModel(@Valid @RequestBody Marca marca) {
        return marcaServiceImp.createMarca(marca);
    }
}
