package com.P1.Proyecto1Ruben_back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa una marca en el sistema.
 * Representa la tabla de la base de datos y se utiliza para mapear los datos entre el sistema y la base de datos.
 */

@Entity
@Table(name = "marca")
public class MarcaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Integer id;
	
	@Getter
    @Setter
    private String nombre;
}
