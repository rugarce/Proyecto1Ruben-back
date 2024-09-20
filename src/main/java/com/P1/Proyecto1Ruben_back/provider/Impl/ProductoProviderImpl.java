package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.dto.ProductoDto;
import com.P1.Proyecto1Ruben_back.entity.ProductoEntity;
import com.P1.Proyecto1Ruben_back.provider.ProductoProvider;
import com.P1.Proyecto1Ruben_back.repository.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoProviderImpl implements ProductoProvider {
	
	@Autowired
	private ProductoRepository repository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ProductoEntity findProductoById(Long id) {
		return repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
	}

	@Override
	public ProductoEntity createProducto(ProductoDto producto) {
		ProductoEntity productoEntity = modelMapper.map(producto, ProductoEntity.class);
		return repository.save(productoEntity);
	}

	@Override
	public ProductoEntity updateProducto(Long id, ProductoDto producto) {
		ProductoEntity productoEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		ProductoEntity productoActualizado = modelMapper.map(producto, ProductoEntity.class);
		productoEntity.setNombre(productoActualizado.getNombre());
		productoEntity.setCantidad(productoActualizado.getCantidad());
		productoEntity.setPrecio(productoActualizado.getPrecio());
		productoEntity.setIdMarca(productoActualizado.getIdMarca());
		productoEntity.setId_proveedor(productoActualizado.getId_proveedor());
		productoEntity.setId_tienda(productoActualizado.getId_tienda());
		return repository.save(productoEntity);
	}

	@Override
	public void deleteProductoById(Long id) {
		repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		repository.deleteById(id);
	}

	@Override
	public List<ProductoEntity> allProducts() {
		return repository.findAll();
	}

}
