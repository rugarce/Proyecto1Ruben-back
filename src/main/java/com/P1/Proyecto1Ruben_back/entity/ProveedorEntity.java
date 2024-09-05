package com.P1.Proyecto1Ruben_back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proveedor")
public class ProveedorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Integer id;

	@Getter
	@Setter
    private String nombre;
	@Getter
	@Setter
    private String direccion;
	@Getter
	@Setter
    private String tfno;
}
