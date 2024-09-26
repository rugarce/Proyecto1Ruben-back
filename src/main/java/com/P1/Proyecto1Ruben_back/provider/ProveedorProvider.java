package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.dto.ProveedorDto;

/**
 * Interfaz de las operaciones de los proveedores.
 * 
 * Esta interfaz define los métodos para realizar operaciones CRUD sobre la entidad proveedor.
 */
public interface ProveedorProvider {
	/**
	 * Encuentra/Busca un proveedor por su id.
	 * @param id El identificador del proveedor a buscar.
	 * @return La entidad proveedor correspondiente al identificador id.
	 */
	ProveedorDto findProveedorById(Long id);
	/**
	 * Crea un proveedor con la información proporcionada.
     * @param proveedor Un objeto ProveedorDto que contiene la informacion del proveedor a crear.
     * @return La entidad proveedor creada, con su identificador generado.
	 */
	Long createProveedor(ProveedorDto proveedor);
	/**
	 * Actualiza un proveedor que existe con la información proporcionada.
     * @param id El identificador del proveedor a actualizar.
     * @param proveedor Un objeto ProveedorDto que contiene la información actualizada del proveedor.
     * @return La entidad proveedor actualizada.
	 */
	ProveedorDto updateProveedor(Long id, ProveedorDto proveedor);
	/**
	 * Elimina un proveedor por su id. 
     * @param id El identificador único del proveedor a eliminar.
	 */
    void deleteProveedorById(Long id);
    /**
     * Obtiene todos los proveedores.
     * 
     * @return Una lista de entidades proveedor que representa todos los proveedores.
     */
    public List<ProveedorDto> allProveedores();
}
