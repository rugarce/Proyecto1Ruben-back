package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.dto.VentaDto;
import com.P1.Proyecto1Ruben_back.entity.VentaEntity;

/**
 * Interfaz de las operaciones de las ventas.
 * 
 * Esta interfaz define los métodos para realizar operaciones CRUD sobre la entidad Venta.
 */

public interface VentaProvider {
	/**
	 * Encuentra/Busca un venta por su id.
	 * @param id El identificador de la venta a buscar.
	 * @return La entidad venta correspondiente al identificador id.
     */
	VentaEntity findVentaById(Long id);
	
	/**
     * Crea una nueva venta con la información proporcionada.
     * 
     * @param venta Un objeto VentaDto que contiene la informacion de la venta a crear.
     * @return La entidad venta creada, con su identificador generado.
     */
	VentaEntity createVenta(VentaDto venta);
	
	/**
     * Actualiza una venta que existe con la información proporcionada.
     * 
     * @param id El identificador de la venta a actualizar.
     * @param venta Un objeto VentaDto que contiene la información actualizada de la venta.
     * @return La entidad venta actualizada.
     */
	VentaEntity updateVenta(Long id, VentaDto venta);
	
	/**
     * Elimina una venta por su id.
     * 
     * @param id El identificador único de la venta a eliminar.
     */
    void deleteVentaById(Long id);
    
    /**
     * Obtiene todas las ventas.
     * 
     * @return Una lista de entidades venta que representa todas las ventas.
     */
    public List<VentaEntity> allVentas();

}
