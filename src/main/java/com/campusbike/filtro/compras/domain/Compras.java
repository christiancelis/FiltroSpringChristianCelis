package com.campusbike.filtro.compras.domain;

import java.util.Date;

import com.campusbike.filtro.proveedores.domain.Proveedores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor
public class Compras {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private Date fecha;

    @NotBlank
    @Column(nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedores proveedores;    
}
