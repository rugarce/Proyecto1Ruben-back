package com.P1.Proyecto1Ruben_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.P1.Proyecto1Ruben_back.entity.MarcaEntity;

/**
 * Interfaz para operaciones relacionadas con la entidad Marca.
 * 
 * Esta interfaz extiende de JpaRepository y proporciona métodos para
 * realizar operaciones CRUD. Además tambien se pueden definir metodos personalizados con la etiqueta @Query.
 */


public interface MarcaRepository extends JpaRepository<MarcaEntity, Long>{
	
	@Query("SELECT m FROM MarcaEntity m WHERE m.nombre = :nombre")
	List<MarcaEntity> findByName(@Param("nombre") String name);

}
