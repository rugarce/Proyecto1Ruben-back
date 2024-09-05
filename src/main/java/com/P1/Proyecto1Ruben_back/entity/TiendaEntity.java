package com.P1.Proyecto1Ruben_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tienda")
public class TiendaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Integer id;

    @Column(unique = true)
    @Getter
    @Setter
    private String nombre;
    
    @Getter
    @Setter
    private String direccion;
}