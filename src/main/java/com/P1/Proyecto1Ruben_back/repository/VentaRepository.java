package com.P1.Proyecto1Ruben_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.P1.Proyecto1Ruben_back.entity.VentaEntity;

/**
 * Interfaz para operaciones relacionadas con la entidad Venta.
 * 
 * Esta interfaz extiende de JpaRepository y proporciona métodos para
 * realizar operaciones CRUD. Además tambien se pueden definir metodos personalizados con la etiqueta @Query.
 */


public interface VentaRepository extends JpaRepository<VentaEntity, Long>{

}
