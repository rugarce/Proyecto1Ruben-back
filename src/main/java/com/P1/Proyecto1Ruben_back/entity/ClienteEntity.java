package com.P1.Proyecto1Ruben_back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa un cliente en el sistema.
 * Representa la tabla de la base de datos y se utiliza para mapear los datos entre el sistema y la base de datos.
 */

@Entity
@Table(name = "Cliente")
public class ClienteEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Long id;
	
	@Getter
	@Setter
	@NotBlank(message = "El nombre no debe ser nulo y debe contener al menos un carácter que no sea un espacio en blanco") 
	@Size(min = 1, max = 20, message = "El nombre debe tener como máximo 20 caracteres y tener al menos un carácter") 
    private String nombre;
	@Getter
	@Setter
	@NotBlank(message = "El apellido no debe ser nulo y debe contener al menos un carácter que no sea un espacio en blanco") 
	@Size(min = 1, max = 20, message = "El apellido debe tener como máximo 20 caracteres y tener al menos un carácter")
    private String apellido1;
	@Getter
	@Setter
	@NotBlank(message = "El apellido no debe ser nulo y debe contener al menos un carácter que no sea un espacio en blanco") 
	@Size(min = 1, max = 20, message = "El apellido debe tener como máximo 20 caracteres y tener al menos un carácter")
    private String apellido2;
	@Getter
	@Setter
	@NotBlank(message = "La dirección no debe ser nula y debe contener al menos un carácter que no sea un espacio en blanco") 
	@Size(min = 1, max = 50, message = "La dirección debe tener como máximo 50 caracteres y tener al menos un carácter")
    private String direccion;
	@Getter
	@Setter
	@NotBlank(message = "El telefono no debe ser nulo y debe contener al menos un carácter que no sea un espacio en blanco") 
	@Size(min = 1, max = 20, message = "El telefono debe tener como máximo 20 caracteres y tener al menos un carácter")
	@Pattern(regexp = "^[+\\d\\s-]+$", message = "El número de teléfono puede contener solo dígitos, espacios, guiones y el símbolo +")
	private String tfno;
	
}

