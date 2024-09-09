package com.campusbike.filtro.detalleVentas.domain;

import com.campusbike.filtro.bicicletas.domain.Bicicletas;
import com.campusbike.filtro.ventas.domain.Ventas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_ventas")
@Getter
@Setter
@NoArgsConstructor
public class DetalleVentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1)
    @Column(nullable = false)
    private int cantidad;

    @NotBlank
    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;


    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Ventas ventas;


    @ManyToOne
    @JoinColumn(name = "bicicleta_id")
    private Bicicletas bicicletas;




    



    

    
}
