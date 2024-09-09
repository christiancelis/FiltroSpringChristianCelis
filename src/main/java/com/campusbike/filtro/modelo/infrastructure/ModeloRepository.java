package com.campusbike.filtro.modelo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusbike.filtro.modelo.domain.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
