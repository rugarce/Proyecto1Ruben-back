package com.P1.Proyecto1Ruben_back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
public class ProductoEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Integer id;
	
	@Getter
    @Setter
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    @Getter
    @Setter
    private MarcaEntity marca;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    @Getter
    @Setter
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "id_tienda")
    @Getter
    @Setter
    private TiendaEntity tienda;

    @Getter
    @Setter
    private float precio;
    @Getter
    @Setter
    private int cantidad;
}
