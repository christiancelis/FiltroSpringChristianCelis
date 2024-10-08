package com.campusbike.filtro.bicicletas.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusbike.filtro.bicicletas.domain.Bicicletas;

@Repository
public interface BicicletaRepository extends JpaRepository<Bicicletas,Long> {
    
}
