package com.P1.Proyecto1Ruben_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;

/**
 * Interfaz para operaciones relacionadas con la entidad Cliente.
 * 
 * Esta interfaz extiende de JpaRepository y proporciona métodos para
 * realizar operaciones CRUD. Además tambien se pueden definir metodos personalizados con la etiqueta @Query.
 */

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	/**
	 * Encuentra al cliente por su nombre.
	 * @param name El nombre a buscar o encontrar.
	 * @return Devuelve una lista de los clientes que tienen por nombre el dado en el parametro name.
	 */
	@Query("SELECT c FROM ClienteEntity c WHERE c.nombre = :nombre")
	List<ClienteEntity> findByName(@Param("nombre") String name);
	
	/**
	 * Encuentra/Busca al cliente según los parametros que especifices.
	 * @param nombre Nombre del cliente(Opcional).
	 * @param apellido1 Primer apellido del cliente(Opcional).
	 * @param apellido2 Segundo apellido del cliente(Opcional).
	 * @param direccion Direccion del cliente(Opcional).
	 * @param tfno Telefono del cliente(Opcional).
	 * @return Devuelve una lista de los clientes cuyos datos coinciden con los valores de los parametros seleccionados. 
	 */
	@Query("SELECT c FROM ClienteEntity c "
			+ "WHERE (:nombre IS NULL OR upper(c.nombre) like concat('%',upper(:nombre),'%')) AND "
			+ "(:apellido1 IS NULL OR upper(c.apellido1) like concat('%',upper(:apellido1),'%')) AND"
			+ "(:apellido2 IS NULL OR upper(c.apellido2) like concat('%',upper(:apellido2),'%')) AND "
			+ "(:direccion IS NULL OR upper(c.direccion) like concat('%',upper(:direccion),'%')) AND "
			+ "(:tfno IS NULL OR c.tfno = :tfno)")
	List<ClienteEntity> findByNombreAndApellido1AndApellido2AndDireccionAndTfno(
			@Param(value = "nombre") String nombre,
			@Param(value = "apellido1") String apellido1, 
			@Param(value = "apellido2") String apellido2,
			@Param(value = "direccion") String direccion,
			@Param(value = "tfno") String tfno);
}
