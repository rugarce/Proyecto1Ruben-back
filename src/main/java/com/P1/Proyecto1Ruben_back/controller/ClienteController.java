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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.P1.Proyecto1Ruben_back.dto.ClienteDto;
import com.P1.Proyecto1Ruben_back.dto.MessageResponseDto;
import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;
import com.P1.Proyecto1Ruben_back.provider.ClienteProvider;

import jakarta.persistence.EntityNotFoundException;

/**
 * Controlador para manejar operaciones relacionadas con clientes.
 * 
 * Este controlador expone rutas/endpoints para realizar operaciones CRUD sobre clientes.
 */



@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	private ClienteProvider provider;
	
	/**
     * Obtiene todos los clientes.
     * 
     * @return Un mensaje con la lista de todas las entidades cliente, o un mensaje de error ante cualquier excepcion.
     */
	@GetMapping("/all")
	public MessageResponseDto<List<ClienteEntity>> allClients(){
		try {
			return MessageResponseDto.success(provider.allClients());
		}catch(Exception e) {
			return MessageResponseDto.fail("Se ha producido un error");
		}
	}
	
	/**
     * Obtiene una lista de clientes por su nombre.
     * 
     * @param name El nombre de los clientes a obtener.
     * @return Un mensaje que contiene una lista de entidades cliente si se encuentra, o un mensaje de error si no se encuentra.
     *  */
	@GetMapping("/nombre/{nombre}")
	public MessageResponseDto<List<ClienteEntity>> findByName(@PathVariable("nombre") String name) {
		try {
			return MessageResponseDto.success(provider.findClienteByName(name)); 
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
	
	/**
     * Encuentra/Busca al cliente según los parametros que especifices.
	 * @param nombre Nombre del cliente(Opcional).
	 * @param apellido1 Primer apellido del cliente(Opcional).
	 * @param apellido2 Segundo apellido del cliente(Opcional).
	 * @param direccion Direccion del cliente(Opcional).
	 * @param tfno Telefono del cliente(Opcional).
	 * @return Devuelve una lista de los clientes cuyos datos coinciden con los valores de los parametros seleccionados. 
     */
	@GetMapping("/buscar")
    public MessageResponseDto<List<ClienteEntity>> buscarClientes(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido1,
            @RequestParam(required = false) String apellido2,
            @RequestParam(required = false) String direccion,
            @RequestParam(required = false) String tfno) {
		try {
			return MessageResponseDto.success(provider.buscarClientes(nombre, apellido1, apellido2, direccion, tfno)); 
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
    }
	
	/**
     * Obtiene un cliente por su identificador.
     * 
     * @param id El identificador del cliente a obtener.
     * @return Un mensaje que contiene la entidad cliente si se encuentra, o un mensaje de error si no se encuentra.
     *  */
	@GetMapping("/{id}")
	public MessageResponseDto<ClienteEntity> findById(@PathVariable Long id) {
		try {
			return MessageResponseDto.success(provider.findClienteById(id));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
		
	}
	
	/**
     * Crea un nuevo cliente.
     * 
     * @param cliente El objeto ClienteDto que contiene los detalles del nuevo cliente.
     * @return Un mensaje que contiene la entidad cliente creada, o un mensaje de error
     *         si algun dato introducido no existe.
     */
	@PostMapping("/create")
	public ClienteEntity createPerson(@RequestBody ClienteDto cliente) {
		return provider.createCliente(cliente);
	}
	
	/**
     * Actualiza un cliente existente.
     * 
     * @param id El identificador del cliente a actualizar.
     * @param cliente El objeto ClienteDto con los detalles actualizados del cliente.
     * @return Un mensaje que contiene la entidad cliente actualizada,
     *         o un mensaje de error si el cliente no se encuentra.
     */
	@PutMapping("/update/{id}")
	public MessageResponseDto<ClienteEntity> updatePerson(@PathVariable Long id ,@RequestBody ClienteDto cliente) {
		try {
			return MessageResponseDto.success(provider.updateCliente(id,cliente));
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
	
	/**
     * Elimina un cliente por su identificador.
     * 
     * @param id El identificador del cliente a eliminar.
     * @return Un mensaje exitoso si el cliente fue eliminado exitosamente, o un mensaje de error si el cliente no se encuentra.
     */
	@DeleteMapping("/delete/{id}")
	public MessageResponseDto<String> deletePerson(@PathVariable Long id) {
		try {
			provider.deleteClienteById(id);
			return MessageResponseDto.success("Cliente con id "+ id +" eliminado.");
		}catch(EntityNotFoundException e) {
			return MessageResponseDto.fail(e.getMessage());
		}
	}
}
