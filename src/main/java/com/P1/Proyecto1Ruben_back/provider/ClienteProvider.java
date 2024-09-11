package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.dto.ClienteDto;
import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;

/**
 * Interfaz de las operaciones de los clientes.
 * 
 * Esta interfaz define los métodos para realizar operaciones CRUD sobre la entidad Cliente.
 */
public interface ClienteProvider {
	/**
	 * Encuentra/Busca un cliente por su id.
	 * @param id El identificador del cliente a buscar.
	 * @return La entidad cliente correspondiente al identificador id.
	 */
	ClienteEntity findClienteById(Long id);
	
	/**
	 * Encuentra/Busca un cliente por su nombre.
	 * @param name El nombre del cliente a buscar.
	 * @return Una lista de entidades cliente cuyos nombres son name.
	 */
	List<ClienteEntity> findClienteByName(String name);
	
	/**
	 * Crea un cliente con la información proporcionada.
     * @param cliente Un objeto ClienteDto que contiene la informacion del cliente a crear.
     * @return La entidad cliente creada, con su identificador generado.
	 */
	ClienteEntity createCliente(ClienteDto cliente);
	
	/**
	 * Actualiza un cliente que existe con la información proporcionada.
     * @param id El identificador del cliente a actualizar.
     * @param cliente Un objeto ClienteDto que contiene la información actualizada del cliente.
     * @return La entidad cliente actualizada.
	 */
	ClienteEntity updateCliente(Long id, ClienteDto cliente);
	
	/**
	 * Elimina un cliente por su id. 
     * @param id El identificador único del cliente a eliminar.
	 */
    void deleteClienteById(Long id);
    
    /**
     * Obtiene todos los clientes.
     * 
     * @return Una lista de entidades cliente que representa todos los clientes.
     */
    public List<ClienteEntity> allClients();
    
    /**
     * Encuentra/Busca al cliente según los parametros que especifices.
	 * @param nombre Nombre del cliente(Opcional).
	 * @param apellido1 Primer apellido del cliente(Opcional).
	 * @param apellido2 Segundo apellido del cliente(Opcional).
	 * @param direccion Direccion del cliente(Opcional).
	 * @param tfno Telefono del cliente(Opcional).
	 * @return Devuelve una lista de los clientes cuyos datos coinciden con los valores de los parametros seleccionados. 
     */
    public List<ClienteEntity> buscarClientes(String nombre, String apellido1, String apellido2, String direccion, String tfno);
}
