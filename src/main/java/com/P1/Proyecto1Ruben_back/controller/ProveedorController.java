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
import com.P1.Proyecto1Ruben_back.dto.ProveedorDto;
import com.P1.Proyecto1Ruben_back.provider.ProveedorProvider;

import jakarta.persistence.EntityNotFoundException;

/**
 * Controlador para manejar operaciones relacionadas con proveedores.
 * 
 * Este controlador expone rutas para realizar operaciones CRUD sobre proveedores.
 */
@RestController
@RequestMapping("/proveedor")
@CrossOrigin(origins = "*")
public class ProveedorController {
	@Autowired
	private ProveedorProvider provider;
	
	/**
     * Obtiene todos los proveedores.
     * 
     * @return Un mensaje con la lista de todas las entidades proveedor, o un mensaje de error ante cualquier excepcion.
     */
	@GetMapping("/all")
	public MessageResponseDto<List<ProveedorDto>> allProveedores(){
		try {
			return MessageResponseDto.success(provider.allProveedores());
		}catch(Exception e) {
			return MessageResponseDto.fail("Se ha producido un error");
		}
	}
	
	/**
     * Obtiene un proveedor por su identificador.
     * 
     * @param id El identificador del proveedor a obtener.
     * @return Un mensaje que contiene la entidad proveedor si se encuentra,
     *         o un mensaje de error si no se encuentra.
     */
	@GetMapping("/{id}")
	public MessageResponseDto<ProveedorDto> findById(@PathVariable Long id) {
		try {
			return MessageResponseDto.success(provider.findProveedorById(id));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
	
	/**
     * Crea un nuevo proveedor.
     * 
     * @param proveedor El objeto ProveedorDto que contiene los detalles del nuevo proveedor.
     * @return Un mensaje que contiene la entidad proveedor creada, o un mensaje de error
     *         si algun dato introducido no existe.
     */
	@PostMapping("/create")
	public Long createPerson(@RequestBody ProveedorDto proveedor) {
		return provider.createProveedor(proveedor);
	}
	
	/**
     * Actualiza un proveedor existente.
     * 
     * @param id El identificador del proveedor a actualizar.
     * @param proveedor El objeto ProveedorDto con los detalles actualizados del proveedor.
     * @return Un mensaje que contiene la entidad proveedor actualizada,
     *         o un mensaje de error si el proveedor no se encuentra.
     */
	@PutMapping("/update/{id}")
	public MessageResponseDto<ProveedorDto> updatePerson(@PathVariable Long id ,@RequestBody ProveedorDto proveedor) {
		try {
			return MessageResponseDto.success(provider.updateProveedor(id, proveedor));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
	
	/**
     * Elimina un proveedor por su identificador.
     * 
     * @param id El identificador del proveedor a eliminar.
     * @return Un mensaje exitoso si el proveedor fue eliminada exitosamente, o un mensaje de error si el proveedor no se encuentra.
     */
	@DeleteMapping("/delete/{id}")
	public MessageResponseDto<String> deletePerson(@PathVariable Long id) {
		try {
			provider.deleteProveedorById(id);
			return MessageResponseDto.success("Proveedor con id "+ id +" eliminado.");
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
}
