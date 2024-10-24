package com.P1.Proyecto1Ruben_back.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/** 
 * Esta clase se utiliza para transferir/transportar datos de producto entre el front y el back.
 */

@Data
public class ProductoDto {
	Long id;
	@NotBlank(message = "El nombre no debe ser nulo y debe contener al menos un carácter que no sea un espacio en blanco") 
	@Size(min = 1, max = 20, message = "El nombre debe tener como máximo 20 caracteres y tener al menos un carácter")
	String nombre;
	@NotNull(message = "El ID de la marca no debe ser nulo")
	Long id_marca;
	@NotNull(message = "El ID del proveedor no debe ser nulo")
	Long id_proveedor;
	@NotNull(message = "El ID de la tienda no debe ser nulo")
	Long id_tienda;
	@Min(value = 1, message = "El precio debe ser mayor o igual a 1")
	Float precio;
	@Min(value = 1, message = "La cantidad debe ser mayor o igual a 1")
	Integer cantidad;
}
