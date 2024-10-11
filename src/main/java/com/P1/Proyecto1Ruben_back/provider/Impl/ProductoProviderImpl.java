package com.P1.Proyecto1Ruben_back.provider.Impl;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.dto.PaginadoDto;
import com.P1.Proyecto1Ruben_back.dto.ProductoAllDto;
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
	public ProductoAllDto findProductoById(Long id) {
		ProductoEntity productoEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		ProductoAllDto productoDto= modelMapper.map(productoEntity, ProductoAllDto.class);
		return productoDto;
	}

	@Override
	public Long createProducto(ProductoDto producto) {
		ProductoEntity productoEntity = modelMapper.map(producto, ProductoEntity.class);
		productoEntity =repository.save(productoEntity);
		return productoEntity.getId();
	}

	@Override
	public ProductoDto updateProducto(ProductoDto producto) {
		ProductoEntity productoEntity = repository.findById(producto.getId()).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + producto.getId() + " no existe."));
		modelMapper.map(producto, productoEntity);
		repository.save(productoEntity);
		return producto;
	}

	@Override
	public void deleteProductoById(Long id) {
		if(id==null) {
			throw new IllegalArgumentException ("El id no puede ser nulo.");
		}
		repository.deleteById(id);
	}

	@Override
	public List<ProductoAllDto> allProducts() {
		List<ProductoEntity> listaEntity = repository.findAll();
		List<ProductoAllDto> listaDto = new ArrayList<ProductoAllDto>();
		for(ProductoEntity l :listaEntity) {
			ProductoAllDto productoDto = modelMapper.map(l, ProductoAllDto.class);
			listaDto.add(productoDto);
		}
		return listaDto;
	}

	@Override
	public PaginadoDto<ProductoAllDto> obtenerProductosPaginados(int numPagina, int tamanoPagina) {
		PaginadoDto<ProductoAllDto> result = new PaginadoDto<ProductoAllDto>();
		
		Pageable page = PageRequest.of(numPagina,tamanoPagina);
		Page<ProductoEntity> allPaginated = repository.getAllPaginated2(page);
		
		for(ProductoEntity l :allPaginated.getContent()) {
			ProductoAllDto productoAllDto = modelMapper.map(l, ProductoAllDto.class);
			result.getContenido().add(productoAllDto);
		}
		result.setNumElementosTotales(allPaginated.getTotalElements());
	    result.setTamPagina(allPaginated.getSize());
		return result;
	}

}
