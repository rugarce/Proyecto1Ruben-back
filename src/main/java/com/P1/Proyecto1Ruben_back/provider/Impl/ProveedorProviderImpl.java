package com.P1.Proyecto1Ruben_back.provider.Impl;

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
	public ProveedorEntity findProveedorById(Long id) {
		return repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El proveedor con ID " + id + " no existe."));
	}

	@Override
	public ProveedorEntity createProveedor(ProveedorDto proveedor) {
		ProveedorEntity proveedorEntity = modelMapper.map(proveedor, ProveedorEntity.class);
		return repository.save(proveedorEntity);
	}

	@Override
	public ProveedorEntity updateProveedor(Long id, ProveedorDto proveedor) {
		ProveedorEntity proveedorEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El proveedor con ID " + id + " no existe."));
		if(proveedorEntity!=null) {
			ProveedorEntity proveedorActualizado = modelMapper.map(proveedor, ProveedorEntity.class);
			proveedorEntity.setNombre(proveedorActualizado.getNombre());
			proveedorEntity.setDireccion(proveedorActualizado.getDireccion());
			proveedorEntity.setTfno(proveedorActualizado.getTfno());
			return repository.save(proveedorEntity);
		}else {
			throw new RuntimeException("Proveedor no encontrado");
		}
	}

	@Override
	public void deleteProveedorById(Long id) {
		repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El proveedor con ID " + id + " no existe."));
		repository.deleteById(id);;
	}

	@Override
	public List<ProveedorEntity> allProveedores() {
		return repository.findAll();
	}

}
