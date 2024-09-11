package com.P1.Proyecto1Ruben_back.dto;

import lombok.Data;

/** 
 * Esta clase se utiliza para transferir/transportar datos de cliente entre el front y el back.
 */

@Data
public class ClienteDto {
	String nombre;
	String apellido1;
	String apellido2;
	String direccion;
	String tfno;
}
