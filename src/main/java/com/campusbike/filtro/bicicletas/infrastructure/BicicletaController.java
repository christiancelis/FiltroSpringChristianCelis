package com.campusbike.filtro.bicicletas.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusbike.filtro.bicicletas.domain.BicicletaDTO;
import com.campusbike.filtro.bicicletas.domain.Bicicletas;
import com.campusbike.filtro.marca.infrastructure.MarcaServiceImp;
import com.campusbike.filtro.modelo.infrastructure.ModeloServiceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/bicicleta")
public class BicicletaController {
    
    @Autowired
    private BicicletaServiceImp bicicletaServiceImp;

    @Autowired
    private MarcaServiceImp marcaServiceImp;

    @Autowired
    ModeloServiceImp modeloServiceImp;



    @GetMapping("")
    public List<Bicicletas> getAllBicicletas() {
        return bicicletaServiceImp.getAllBicicletas();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAllBicicletas(@PathVariable Long id) {
        try {
            Bicicletas bici = bicicletaServiceImp.getBicicletaById(id);
            return ResponseEntity.ok().body(bici);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }


    @PostMapping("")
    public ResponseEntity<?> crearBicicleta(@RequestBody BicicletaDTO bicicletaDto) {
        Bicicletas bicicletas = new Bicicletas();
        if(modeloServiceImp.getModelById(bicicletaDto.getIdModelo())!=null){
            bicicletas.setModelo(modeloServiceImp.getModelById(bicicletaDto.getIdModelo()));
        }
        if(marcaServiceImp.getMarcaById(bicicletaDto.getIdMarca())!=null){
            bicicletas.setMarca(marcaServiceImp.getMarcaById(bicicletaDto.getIdMarca()));
        }

        bicicletas.setPrecio(bicicletaDto.getPrecio());
        bicicletaDto.setStock(bicicletaDto.getStock());

        if(bicicletaServiceImp.createBicicleta(bicicletas)!=null){
            return ResponseEntity.ok().body(bicicletas);
        }

        return ResponseEntity.badRequest().build();

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBicicletaById(@PathVariable Long id){
        Bicicletas bici = bicicletaServiceImp.deleteBicicletaById(id);
        if(bici.getId()!=null){
            return ResponseEntity.ok().body(bici);
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBicicletas(@PathVariable Long id, @RequestBody BicicletaDTO bicicletaDTO) {
        Bicicletas bici = bicicletaServiceImp.getBicicletaById(id);


            if(modeloServiceImp.getModelById(bicicletaDTO.getIdModelo())==null){
                return ResponseEntity.badRequest().build();
            }

            if(marcaServiceImp.getMarcaById(bicicletaDTO.getIdMarca())==null){
                return ResponseEntity.badRequest().build();
            }

            bici.setPrecio(bicicletaDTO.getPrecio());
            bici.setStock(bicicletaDTO.getStock());
            bici.setMarca(marcaServiceImp.getMarcaById(bicicletaDTO.getIdMarca()));
            bici.setModelo(modeloServiceImp.getModelById(bicicletaDTO.getIdModelo()));

            if(bicicletaServiceImp.updateBicicletas(id,bici)!=null){
                return ResponseEntity.ok().body(bici);
            };

            return ResponseEntity.badRequest().build();
    }


    

}
