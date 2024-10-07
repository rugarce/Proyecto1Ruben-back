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
	public ProductoDto updateProducto(Long id, ProductoDto producto) {
		ProductoEntity productoEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		ProductoEntity productoActualizado = modelMapper.map(producto, ProductoEntity.class);
		productoEntity.setNombre(productoActualizado.getNombre());
		productoEntity.setCantidad(productoActualizado.getCantidad());
		productoEntity.setPrecio(productoActualizado.getPrecio());
		productoEntity.setId_marca(productoActualizado.getId_marca());
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
	public PaginadoDto<ProductoAllDto> obtenerProductosPaginados(int NumPagina, int TamanoPagina) {
		PaginadoDto<ProductoAllDto> result = new PaginadoDto<ProductoAllDto>();
		result.setContenido(new ArrayList<ProductoAllDto>());
		Pageable page = PageRequest.of(NumPagina,TamanoPagina);
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
