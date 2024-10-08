package com.P1.Proyecto1Ruben_back.dto;



import lombok.Data;

@Data
public class ContactoDto {
	private String correo;
	private String nombre;
    private String asunto;
    private String mensaje;
}
