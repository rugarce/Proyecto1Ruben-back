package com.P1.Proyecto1Ruben_back.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) para dar un mensaje de respuesta.
 * 
 * Esta clase se utiliza para enviar mensajes desde el back hacia el front,
 * indicando el resultado de una operación/metodo, ya sea satisfactoria o erronea.
 */

@Data
public class MessageResponseDto<T> {

	boolean success;
	String error;
	T message;
	
	/**
	 * Indica que la operación se ha realizado con exito.
	 * @param <T> Objeto que devuelve el metodo.
	 * @param message El objeto T representa el resultado de la operacion/funcion exitosa.
	 * @return Un objeto que contiene el mensaje y un indicador de exito. 
	 */
	public static <T> MessageResponseDto<T> success(T message) {
		MessageResponseDto<T> dto = new MessageResponseDto<T>();
		dto.setMessage(message);
		dto.setSuccess(true);
		return dto;
	}
	
	/**
	 * Indica que la operación ha fallado.
	 * @param <T> Objeto que devuelve el metodo.
	 * @param error Mensaje de error que describe la causa del fallo.
	 * @return Un objeto que contiene el mensaje de error y un indicador de fallo.
	 */
	public static <T> MessageResponseDto<T> fail(String error) {
		MessageResponseDto<T> dto = new MessageResponseDto<T>();
		dto.setSuccess(false);
		dto.setError(error);
		return dto;
	}
	
}


