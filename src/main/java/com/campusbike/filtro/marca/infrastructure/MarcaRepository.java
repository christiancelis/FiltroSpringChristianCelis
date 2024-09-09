package com.campusbike.filtro.marca.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusbike.filtro.marca.domain.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long> {

}
