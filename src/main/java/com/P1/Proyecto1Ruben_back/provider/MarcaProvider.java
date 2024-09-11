package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.dto.MarcaDto;
import com.P1.Proyecto1Ruben_back.entity.MarcaEntity;

/**
 * Interfaz de las operaciones de las marcas.
 * 
 * Esta interfaz define los métodos para realizar operaciones CRUD sobre la entidad Marca.
 */
public interface MarcaProvider {
	/**
	 * Encuentra/Busca una marca por su id.
	 * @param id El identificador de la marca a buscar.
	 * @return La entidad marca correspondiente al identificador id.
	 */
	MarcaEntity findMarcaById(Long id);
	/**
	 * Crea una nueva marca con la información proporcionada.
     * @param marca Un objeto MarcaDto que contiene la informacion de la marca a crear.
     * @return La entidad marca creada, con su identificador generado.
	 */
	MarcaEntity createMarca(MarcaDto marca);
	/**
	 * Actualiza una marca que existe con la información proporcionada.
     * @param id El identificador de la marca a actualizar.
     * @param marca Un objeto MarcaDto que contiene la información actualizada de la marca.
     * @return La entidad marca actualizada.
	 */
	MarcaEntity updateMarca(Long id, MarcaDto marca);
	/**
	 * Elimina una marca por su id. 
     * @param id El identificador único de la marca a eliminar.
	 */
    void deleteMarcaById(Long id);
    /**
     * Obtiene todas las marcas.
     * 
     * @return Una lista de entidades marca que representa todas las marcas.
     */
    public List<MarcaEntity> allMarcas();
}
