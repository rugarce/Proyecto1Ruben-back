package com.P1.Proyecto1Ruben_back.provider.Impl;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public ProductoDto findProductoById(Long id) {
		ProductoEntity productoEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		ProductoDto productoDto= modelMapper.map(productoEntity, ProductoDto.class);
		return productoDto;
	}

	@Override
	public Long createProducto(ProductoDto producto) {
		ProductoEntity productoEntity = modelMapper.map(producto, ProductoEntity.class);
		productoEntity =repository.save(productoEntity);
		return productoEntity.getId();
	}

	@Override
	public ProductoDto updateProducto(Long id, ProductoDto producto) {
		ProductoEntity productoEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		ProductoEntity productoActualizado = modelMapper.map(producto, ProductoEntity.class);
		productoEntity.setNombre(productoActualizado.getNombre());
		productoEntity.setCantidad(productoActualizado.getCantidad());
		productoEntity.setPrecio(productoActualizado.getPrecio());
		productoEntity.setIdMarca(productoActualizado.getIdMarca());
		productoEntity.setId_proveedor(productoActualizado.getId_proveedor());
		productoEntity.setId_tienda(productoActualizado.getId_tienda());
		repository.save(productoEntity);
		producto = modelMapper.map(productoEntity, ProductoDto.class);
		return producto;
	}

	@Override
	public void deleteProductoById(Long id) {
		repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		repository.deleteById(id);
	}

	@Override
	public List<ProductoDto> allProducts() {
		List<ProductoEntity> listaEntity = repository.findAll();
		List<ProductoDto> listaDto = new ArrayList<ProductoDto>();
		for(ProductoEntity l :listaEntity) {
			ProductoDto productoDto = modelMapper.map(l, ProductoDto.class);
			listaDto.add(productoDto);
		}
		return listaDto;
	}

	@Override
	public List<ProductoDto> obtenerProductosPaginados(int NumPagina, int TamanoPagina) {
		List<ProductoDto> result = new ArrayList<ProductoDto>();
		Pageable page = PageRequest.of(0, 12);
		if(NumPagina>=1 && TamanoPagina>=1) {
			page = PageRequest.of(NumPagina, TamanoPagina);
		}
		List<ProductoEntity> allPaginated = repository.getAllPaginated(page);
		for(ProductoEntity l :allPaginated) {
			ProductoDto productoDto = modelMapper.map(l, ProductoDto.class);
			result.add(productoDto);
		}
		return result;
	}

}
