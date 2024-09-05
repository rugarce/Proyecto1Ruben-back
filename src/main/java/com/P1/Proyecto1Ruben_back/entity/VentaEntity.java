package com.P1.Proyecto1Ruben_back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "venta")
public class VentaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    @Getter
    private ProductoEntity producto;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @Getter
    private ClienteEntity cliente;
}
