package com.P1.Proyecto1Ruben_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.P1.Proyecto1Ruben_back.dto.MessageResponseDto;
import com.P1.Proyecto1Ruben_back.dto.VentaDto;
import com.P1.Proyecto1Ruben_back.provider.VentaProvider;

import jakarta.persistence.EntityNotFoundException;

/**
 * Controlador para manejar operaciones relacionadas con ventas.
 * 
 * Este controlador expone rutas para realizar operaciones CRUD sobre ventas.
 */
@RestController
@RequestMapping("/venta")
@CrossOrigin(origins = "*")
public class VentaController {
	@Autowired
	private VentaProvider provider;
	
	/**
     * Obtiene todas las ventas.
     * 
     * @return Un mensaje con la lista de todas las entidades venta, o un mensaje de error ante cualquier excepcion.
     */
	@GetMapping("/all")
	public MessageResponseDto<List<VentaDto>> allVents(){
		try {
			return MessageResponseDto.success(provider.allVentas());
		}catch(Exception e) {
			return MessageResponseDto.fail("Se ha producido un error");
		}
	}
	
	/**
     * Crea una nueva venta.
     * 
     * @param venta El objeto VentaDto que contiene los detalles de la nueva venta.
     * @return Un mensaje que contiene la entidad venta creada, o un mensaje de error
     *         si algun dato introducido no existe.
     */
	@PostMapping("/create")
	public MessageResponseDto<Long> createVenta(@RequestBody VentaDto venta) {
		try {
			return MessageResponseDto.success(provider.createVenta(venta));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail("Error al crear la venta, compruebe que el producto y el cliente existen.");
		}
	}
	
	/**
     * Obtiene una venta por su identificador.
     * 
     * @param id El identificador de la venta a obtener.
     * @return Un mensaje que contiene la entidad venta si se encuentra,
     *         o un mensaje de error si no se encuentra.
     */
	@GetMapping("/{id}")
	public MessageResponseDto<VentaDto> findById(@PathVariable Long id) {
		try {
			return MessageResponseDto.success(provider.findVentaById(id));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
	
	 /**
     * Actualiza una venta existente.
     * 
     * @param id El identificador de la venta a actualizar.
     * @param venta El objeto VentaDto con los detalles actualizados de la venta.
     * @return Un mensaje que contiene la entidad venta actualizada,
     *         o un mensaje de error si la venta no se encuentra.
     */
	@PutMapping("/update/{id}")
	public MessageResponseDto<VentaDto> updateVenta(@PathVariable Long id ,@RequestBody VentaDto venta) {
		try {
			return MessageResponseDto.success(provider.updateVenta(id, venta));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
	
	/**
     * Elimina una venta por su identificador.
     * 
     * @param id El identificador de la venta a eliminar.
     * @return Un mensaje exitoso si la venta fue eliminada exitosamente, o un mensaje de error si la venta no se encuentra.
     */
	@DeleteMapping("/delete/{id}")
	public MessageResponseDto<String> deleteVenta(@PathVariable Long id) {
		try {
			provider.deleteVentaById(id);
			return MessageResponseDto.success("La venta con id "+id+" ha sido eliminada.");
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}

}
