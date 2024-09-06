package com.P1.Proyecto1Ruben_back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
public class ClienteEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Long id;
	
	@Getter
	@Setter
    private String nombre;
	@Getter
	@Setter
    private String apellidos;
	@Getter
	@Setter
    private String direccion;
	@Getter
	@Setter
    private String tfno;
	
}

