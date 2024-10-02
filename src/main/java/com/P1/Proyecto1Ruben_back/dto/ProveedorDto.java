package com.P1.Proyecto1Ruben_back.dto;

import lombok.Data;

/** 
 * Esta clase se utiliza para transferir/transportar datos de proveedor entre el front y el back.
 */

@Data
public class ProveedorDto {
	Long id;
	String nombre;
	String direccion;
	String tfno;
}
