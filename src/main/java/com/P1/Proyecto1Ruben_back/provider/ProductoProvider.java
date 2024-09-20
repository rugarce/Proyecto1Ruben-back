package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.dto.ProductoDto;
import com.P1.Proyecto1Ruben_back.entity.ProductoEntity;

/**
 * Interfaz de las operaciones de los productos.
 * 
 * Esta interfaz define los métodos para realizar operaciones CRUD sobre la entidad Producto.
 */
public interface ProductoProvider {
	/**
	 * Encuentra/Busca un producto por su id.
	 * @param id El identificador del producto a buscar.
	 * @return La entidad producto correspondiente al identificador id.
	 */
	ProductoEntity findProductoById(Long id);
	/**
	 * Crea un producto con la información proporcionada.
     * @param producto Un objeto ProductoDto que contiene la informacion del producto a crear.
     * @return La entidad producto creada, con su identificador generado.
	 */
	ProductoEntity createProducto(ProductoDto producto);
	/**
	 * Actualiza un producto que existe con la información proporcionada.
     * @param id El identificador del producto a actualizar.
     * @param producto Un objeto ProductoDto que contiene la información actualizada del producto.
     * @return La entidad producto actualizada.
	 */
	ProductoEntity updateProducto(Long id, ProductoDto producto);
	/**
	 * Elimina un producto por su id. 
     * @param id El identificador único del producto a eliminar.
	 */
    void deleteProductoById(Long id);
    /**
     * Obtiene todos los productos.
     * 
     * @return Una lista de entidades producto que representa todos los productos.
     */
    public List<ProductoEntity> allProducts();
}


