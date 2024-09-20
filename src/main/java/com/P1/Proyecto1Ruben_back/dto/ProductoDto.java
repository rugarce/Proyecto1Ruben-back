package com.P1.Proyecto1Ruben_back.dto;

import lombok.Data;

/** 
 * Esta clase se utiliza para transferir/transportar datos de producto entre el front y el back.
 */

@Data
public class ProductoDto {
	String nombre;
	Long idMarca;
	Long id_proveedor;
	Long id_tienda;
	Float precio;
	Integer cantidad;
}
