package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.dto.TiendaDto;
import com.P1.Proyecto1Ruben_back.entity.TiendaEntity;

/**
 * Interfaz de las operaciones de las tiendas.
 * 
 * Esta interfaz define los métodos para realizar operaciones CRUD sobre la entidad Tienda.
 */
public interface TiendaProvider {
	/**
	 * Encuentra/Busca una tienda por su id.
	 * @param id El identificador de la tienda a buscar.
	 * @return La entidad tienda correspondiente al identificador id.
	 */
	TiendaEntity findTiendaById(Long id);
	
	/**
	 * Crea una nueva tienda con la información proporcionada.
     * @param tienda Un objeto TiendaDto que contiene la informacion de la tienda a crear.
     * @return La entidad tienda creada, con su identificador generado.
	 */
	TiendaEntity createTienda(TiendaDto tienda);
	
	/**
	 * Actualiza una tienda que existe con la información proporcionada.
     * @param id El identificador de la tienda a actualizar.
     * @param tienda Un objeto TiendaDto que contiene la información actualizada de la tienda.
     * @return La entidad tienda actualizada.
	 */
	TiendaEntity updateTienda(Long id, TiendaDto tienda);
	
	/**
	 * Elimina una tienda por su id. 
     * @param id El identificador único de la tienda a eliminar.
	 */
    void deleteTiendaById(Long id);
    
    /**
     * Obtiene todas las tiendas.
     * 
     * @return Una lista de entidades tienda que representa todas las tiendas.
     */
    public List<TiendaEntity> allTiendas();
}
