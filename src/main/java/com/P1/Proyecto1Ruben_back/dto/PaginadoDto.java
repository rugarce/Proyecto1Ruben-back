package com.P1.Proyecto1Ruben_back.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PaginadoDto<T> {
	int tamPagina;
	long numElementosTotales;
	List<T> contenido;
	
	 public PaginadoDto() {
	        this.contenido = new ArrayList<T>();
	 }
}
