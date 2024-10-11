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

import com.P1.Proyecto1Ruben_back.dto.MarcaDto;
import com.P1.Proyecto1Ruben_back.dto.MessageResponseDto;
import com.P1.Proyecto1Ruben_back.provider.MarcaProvider;

import jakarta.persistence.EntityNotFoundException;

/**
 * Controlador para manejar operaciones relacionadas con marcas.
 * 
 * Este controlador expone rutas para realizar operaciones CRUD sobre marcas.
 */
@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "*")
public class MarcaController {
	@Autowired
	private MarcaProvider provider;
	
	/**
     * Obtiene todas las marcas.
     * 
     * @return Un mensaje con la lista de todas las entidades marca, o un mensaje de error ante cualquier excepcion.
     */
	@GetMapping("/all")
	public MessageResponseDto<List<MarcaDto>> allMarcas(){
		try {
			return MessageResponseDto.success(provider.allMarcas());
		}catch(Exception e) {
			return MessageResponseDto.fail("Se ha producido un error");
		}
	}
	
	/**
     * Obtiene una marca por su identificador.
     * 
     * @param id El identificador de la marca a obtener.
     * @return Un mensaje que contiene la entidad marca si se encuentra,
     *         o un mensaje de error si no se encuentra.
     */
	@GetMapping("/{id}")
	public MessageResponseDto<MarcaDto> findById(@PathVariable Long id) {
		try {
			return MessageResponseDto.success(provider.findMarcaById(id));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
		
	}
	
	/**
     * Crea una nueva marca.
     * 
     * @param marca El objeto MarcaDto que contiene los detalles de la nueva marca.
     * @return Un mensaje que contiene la entidad marca creada, o un mensaje de error
     *         si algun dato introducido no existe.
     */
	@PostMapping("/create")
	public Long createPerson(@RequestBody MarcaDto marca) {
		return provider.createMarca(marca);
	}
	
	/**
     * Actualiza una marca existente.
     * 
     * @param id El identificador de la marca a actualizar.
     * @param marca El objeto MarcaDto con los detalles actualizados de la marca.
     * @return Un mensaje que contiene la entidad marca actualizada,
     *         o un mensaje de error si la marca no se encuentra.
     */
	@PutMapping("/update/{id}")
	public MessageResponseDto<MarcaDto> updatePerson(@RequestBody MarcaDto marca) {
		try {
			return MessageResponseDto.success(provider.updateMarca(marca));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
	
	/**
     * Elimina una marca por su identificador.
     * 
     * @param id El identificador de la marca a eliminar.
     * @return Un mensaje exitoso si la marca fue eliminada exitosamente, o un mensaje de error si la marca no se encuentra.
     */
	@DeleteMapping("/delete/{id}")
	public MessageResponseDto<String> deletePerson(@PathVariable Long id) {
		try {
			provider.deleteMarcaById(id);
			return MessageResponseDto.success("Marca con id "+ id +" eliminada");
		}catch(IllegalArgumentException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
}
