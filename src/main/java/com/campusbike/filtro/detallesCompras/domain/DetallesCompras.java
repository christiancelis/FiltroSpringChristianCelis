package com.campusbike.filtro.detallesCompras.domain;

import com.campusbike.filtro.compras.domain.Compras;
import com.campusbike.filtro.repuestos.domain.Repuestos;

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
@Table(name = "detalles_compras")
@Setter
@Getter
@NoArgsConstructor
public class DetallesCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private int cantidad;

    @NotBlank
    @Column(name = "precio_unitario",nullable = false)
    private double precioUnitario;

    @ManyToOne
    @JoinColumn(name="compra_id")
    private Compras compras;

    @ManyToOne
    @JoinColumn(name = "repuesto_id")
    private Repuestos repuestos;
}
