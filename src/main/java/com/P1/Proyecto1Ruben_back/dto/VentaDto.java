package com.P1.Proyecto1Ruben_back.dto;

import lombok.Data;

/** 
 * Esta clase se utiliza para transferir/transportar datos de venta entre el front y el back.
 */

@Data
public class VentaDto {
	Long id;
	Long id_producto;
	Long id_cliente;
}
