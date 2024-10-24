package com.P1.Proyecto1Ruben_back.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.P1.Proyecto1Ruben_back.entity.ProductoEntity;

/**
 * Interfaz para operaciones relacionadas con la entidad Producto.
 * 
 * Esta interfaz extiende de JpaRepository y proporciona métodos para realizar
 * operaciones CRUD. Además tambien se pueden definir metodos personalizados con
 * la etiqueta @Query.
 */

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

	@Query("select p from ProductoEntity p")
	Page<ProductoEntity> getAllPaginated(Pageable pageable);

	@Query("SELECT p FROM ProductoEntity p "
		     + "WHERE (:nombre IS NULL OR upper(p.nombre) LIKE concat('%', upper(:nombre), '%')) AND "
		     + "(COALESCE(:marcas, NULL) IS NULL OR p.marca.nombre IN :marcas) AND "
		     + "(COALESCE(:tiendas, NULL) IS NULL OR p.tienda.nombre IN :tiendas) AND "
		     + "(COALESCE(:proveedores, NULL) IS NULL OR p.proveedor.nombre IN :proveedores) AND "
		     + "(:precio IS NULL OR p.precio <= :precio) AND "
		     + "(:cantidad IS NULL OR p.cantidad >= :cantidad)")
		Page<ProductoEntity> filtrarProductos(
		     @Param("nombre") String nombre,
		     @Param("marcas") List<String> marcas,
		     @Param("tiendas") List<String> tiendas,
		     @Param("proveedores") List<String> proveedores,
		     @Param("precio") Float precio,
		     @Param("cantidad") Integer cantidad,
		     Pageable pageable);

	@Query("SELECT p FROM ProductoEntity p "
			+ "WHERE (:nombre IS NULL OR upper(p.nombre) like concat('%',upper(:nombre),'%')) AND "
			+ "(:marca IS NULL OR upper(p.marca.nombre) like concat('%',upper(:marca),'%')) AND"
			+ "(:tienda IS NULL OR upper(p.tienda.nombre) like concat('%',upper(:tienda),'%')) AND "
			+ "(:precio IS NULL OR p.precio <= :precio) AND " + "(:cantidad IS NULL OR p.cantidad >= :cantidad)")
	List<ProductoEntity> filtrarListProductos(@Param(value = "nombre") String nombre,
			@Param(value = "marca") String marca, @Param(value = "tienda") String tienda,
			@Param(value = "precio") Float precio, @Param(value = "cantidad") Integer cantidad);
}