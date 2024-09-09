package com.campusbike.filtro.clientes.domain;



import org.hibernate.annotations.ManyToAny;

import com.campusbike.filtro.ciudades.domain.Ciudades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Setter
@Getter
@NoArgsConstructor
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Email
    @NotBlank
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @NotBlank
    @Size(min = 8, max = 20 )
    @Column(nullable = false)
    private Long telefono;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "ciudades_id")
    private Ciudades ciudades;

}
