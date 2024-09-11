package com.P1.Proyecto1Ruben_back.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.P1.Proyecto1Ruben_back.entity.ProductoEntity;

/**
 * Interfaz para operaciones relacionadas con la entidad Producto.
 * 
 * Esta interfaz extiende de JpaRepository y proporciona métodos para
 * realizar operaciones CRUD. Además tambien se pueden definir metodos personalizados con la etiqueta @Query.
 */

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}