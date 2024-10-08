package com.P1.Proyecto1Ruben_back.dto;

import lombok.Data;

@Data
public class ProductoAllDto {
	Long id;
	String nombre;
	MarcaDto marca;
	ProveedorDto proveedor;
	TiendaDto tienda;
	Float precio;
	Integer cantidad;
}
