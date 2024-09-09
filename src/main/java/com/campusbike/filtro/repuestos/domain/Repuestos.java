package com.campusbike.filtro.repuestos.domain;

import com.campusbike.filtro.marca.domain.Marca;
import com.campusbike.filtro.modelo.domain.Modelo;
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
@Table(name = "repuestos")
@Getter
@Setter
@NoArgsConstructor
public class Repuestos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String descripcion;

    @NotBlank
    @Column(nullable = false)
    private double precio;

    @NotBlank
    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "proveedores_id")
    private Proveedores proveedores;
    
}
