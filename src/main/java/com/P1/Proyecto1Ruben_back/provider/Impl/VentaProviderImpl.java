package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.dto.VentaDto;
import com.P1.Proyecto1Ruben_back.entity.VentaEntity;
import com.P1.Proyecto1Ruben_back.provider.VentaProvider;
import com.P1.Proyecto1Ruben_back.repository.VentaRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class VentaProviderImpl implements VentaProvider {
	
	@Autowired
	private VentaRepository repository;
	@Autowired
	ModelMapper modelMapped;

	@Override
	public VentaEntity findVentaById(Long id) {
		return repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
	}

	@Override
	public VentaEntity createVenta(VentaDto venta) {
		VentaEntity ventaEntity = modelMapped.map(venta, VentaEntity.class);
//		ventaEntity.getProducto().setCantidad(ventaEntity.getProducto().getCantidad() - 1);
		return repository.save(ventaEntity);
	}

	@Override
	public VentaEntity updateVenta(Long id, VentaDto venta) {
		VentaEntity ventaEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		VentaEntity ventaActualizada = modelMapped.map(venta, VentaEntity.class);
		
//		ventaEntity.getProducto().setCantidad(ventaEntity.getProducto().getCantidad() + 1);
//		ventaActualizada.getProducto().setCantidad(ventaActualizada.getProducto().getCantidad() - 1);
		
		ventaEntity.setId_cliente(ventaActualizada.getId_cliente());
		ventaEntity.setId_producto(ventaActualizada.getId_producto());
		return repository.save(ventaEntity);
	}

	@Override
	public void deleteVentaById(Long id) {
		VentaEntity ventaEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		ventaEntity.getProducto().setCantidad(ventaEntity.getProducto().getCantidad() + 1);
		repository.deleteById(id);
	}

	@Override
	public List<VentaEntity> allVentas() {
		return repository.findAll();
	}

}
