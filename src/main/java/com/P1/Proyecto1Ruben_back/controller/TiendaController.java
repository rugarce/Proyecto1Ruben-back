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
import com.P1.Proyecto1Ruben_back.dto.TiendaDto;
import com.P1.Proyecto1Ruben_back.entity.TiendaEntity;
import com.P1.Proyecto1Ruben_back.provider.TiendaProvider;

import jakarta.persistence.EntityNotFoundException;

/**
 * Controlador para manejar operaciones relacionadas con tiendas.
 * 
 * Este controlador expone rutas/endpoints para realizar operaciones CRUD sobre tiendas.
 */
@RestController
@RequestMapping("/tienda")
@CrossOrigin(origins = "*")
public class TiendaController {
	@Autowired
	private TiendaProvider provider;
	
	/**
     * Obtiene todas las tiendas.
     * 
     * @return Un mensaje con la lista de todas las entidades tienda, o un mensaje de error ante cualquier excepcion.
     */
	@GetMapping("/all")
	public MessageResponseDto<List<TiendaEntity>> allTiendas(){
		try {
			return MessageResponseDto.success(provider.allTiendas());
		}catch(Exception e) {
			return MessageResponseDto.fail("Se ha producido un error");
		}
	}
	
	/**
     * Obtiene una tienda por su identificador.
     * 
     * @param id El identificador de la tienda a obtener.
     * @return Un mensaje que contiene la entidad tienda si se encuentra,
     *         o un mensaje de error si no se encuentra.
     */
	@GetMapping("/{id}")
	public MessageResponseDto<TiendaEntity> findById(@PathVariable Long id) {
		try {
			return MessageResponseDto.success(provider.findTiendaById(id));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
	
	/**
     * Crea una nueva tienda.
     * 
     * @param tienda El objeto TiendaDto que contiene los detalles de la nueva tienda.
     * @return Un mensaje que contiene la entidad tienda creada, o un mensaje de error
     *         si algun dato introducido no existe.
     */
	@PostMapping("/create")
	public TiendaEntity createTienda(@RequestBody TiendaDto tienda) {
		return provider.createTienda(tienda);
	}
	
	/**
     * Actualiza una tienda existente.
     * 
     * @param id El identificador de la tienda a actualizar.
     * @param tienda El objeto TiendaDto con los detalles actualizados de la tienda.
     * @return Un mensaje que contiene la entidad tienda actualizada,
     *         o un mensaje de error si la tienda no se encuentra.
     */
	@PutMapping("/update/{id}")
	public MessageResponseDto<TiendaEntity> updateTienda(@PathVariable Long id ,@RequestBody TiendaDto tienda) {
		try {
			return MessageResponseDto.success(provider.updateTienda(id, tienda));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
	
	/**
     * Elimina una tienda por su identificador.
     * 
     * @param id El identificador de la tienda a eliminar.
     * @return Un mensaje exitoso si la tienda fue eliminada exitosamente, o un mensaje de error si la tienda no se encuentra.
     */
	@DeleteMapping("/delete/{id}")
	public MessageResponseDto<String> deleteTienda(@PathVariable Long id) {
		try {
			provider.deleteTiendaById(id);
			return MessageResponseDto.success("La tienda con id "+ id +" ha sido eliminada.");
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
}
