package com.P1.Proyecto1Ruben_back.providerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.P1.Proyecto1Ruben_back.entity.ProveedorEntity;
import com.P1.Proyecto1Ruben_back.provider.ProveedorProvider;
import com.P1.Proyecto1Ruben_back.repository.ProveedorRepository;

public class ProveedorProviderImpl implements ProveedorProvider{
	
	@Autowired
	ProveedorRepository repository;

	@Override
	public ProveedorEntity findProveedorById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public ProveedorEntity createProveedor(ProveedorEntity proveedor) {
		// TODO Auto-generated method stub
		return repository.save(proveedor);
	}

	@Override
	public ProveedorEntity updateProveedor(ProveedorEntity proveedor) {
		// TODO Auto-generated method stub
		return repository.save(proveedor);
	}

	@Override
	public void deleteProveedorById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);;
	}

	@Override
	public List<ProveedorEntity> allMProveedores() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
