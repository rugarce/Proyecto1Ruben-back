package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.dto.ProveedorDto;
import com.P1.Proyecto1Ruben_back.entity.ProveedorEntity;
import com.P1.Proyecto1Ruben_back.provider.ProveedorProvider;
import com.P1.Proyecto1Ruben_back.repository.ProveedorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProveedorProviderImpl implements ProveedorProvider{
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	ProveedorRepository repository;

	@Override
	public ProveedorDto findProveedorById(Long id) {
		ProveedorEntity proveedorEntity= repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El proveedor con ID " + id + " no existe."));
		ProveedorDto proveedorDto = modelMapper.map(proveedorEntity, ProveedorDto.class);
		return proveedorDto;
	}

	@Override
	public Long createProveedor(ProveedorDto proveedor) {
		ProveedorEntity proveedorEntity = modelMapper.map(proveedor, ProveedorEntity.class);
		repository.save(proveedorEntity);
		return proveedorEntity.getId();
	}

	@Override
	public ProveedorDto updateProveedor(ProveedorDto proveedor) {
		ProveedorEntity proveedorEntity = repository.findById(proveedor.getId())
				.orElseThrow( () -> new EntityNotFoundException("El proveedor con ID " + proveedor.getId() + " no existe."));
		modelMapper.map(proveedor, proveedorEntity);
		repository.save(proveedorEntity);
		return proveedor;
	}

	@Override
	public void deleteProveedorById(Long id) {
		if(id==null) {
			throw new IllegalArgumentException ("El id no puede ser nulo.");
		}
		repository.deleteById(id);;
	}

	@Override
	public List<ProveedorDto> allProveedores() {
		List<ProveedorEntity> listaEntity = repository.findAll();
		List<ProveedorDto> listaDto = new ArrayList<ProveedorDto>();
		for(ProveedorEntity l :listaEntity) {
			ProveedorDto proveedorDto = modelMapper.map(l, ProveedorDto.class);
			listaDto.add(proveedorDto);
		}
		return listaDto;
	}

}
