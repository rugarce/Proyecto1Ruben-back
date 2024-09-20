package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.dto.ClienteDto;
import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;
import com.P1.Proyecto1Ruben_back.provider.ClienteProvider;
import com.P1.Proyecto1Ruben_back.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteProviderImpl implements ClienteProvider{
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ClienteEntity findClienteById(Long id) {
		return repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El cliente con ID " + id + " no existe."));
	}

	@Override
	public ClienteEntity createCliente(ClienteDto cliente) {
		ClienteEntity clienteEntity = modelMapper.map(cliente, ClienteEntity.class);
		
		return repository.save(clienteEntity);
	}

	@Override
	public ClienteEntity updateCliente(Long id, ClienteDto cliente) {
		ClienteEntity clienteEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El cliente con ID " + id + " no existe."));
		ClienteEntity clienteActualizado = modelMapper.map(cliente, ClienteEntity.class);
		clienteEntity.setNombre(clienteActualizado.getNombre());
		clienteEntity.setApellido1(clienteActualizado.getApellido1());
		clienteEntity.setApellido2(clienteActualizado.getApellido2());
		clienteEntity.setDireccion(clienteActualizado.getDireccion());
		clienteEntity.setTfno(clienteActualizado.getTfno());
		return repository.save(clienteEntity);
	}

	@Override
	public void deleteClienteById(Long id) {
		repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El cliente con ID " + id + " no existe."));
		repository.deleteById(id);
	}

	@Override
	public List<ClienteEntity> allClients() {
		return repository.findAll();
	}

	@Override
	public List<ClienteEntity> findClienteByName(String name) {
		if(!repository.findByName(name).isEmpty()){
			return repository.findByName(name);
		}else {
			throw new EntityNotFoundException("El cliente con nombre " + name + " no existe.");
		}
		
	}

	@Override
	public List<ClienteEntity> buscarClientes(String nombre, String apellido1, String apellido2, String direccion,
			String tfno) {
		if(!repository.findByNombreAndApellido1AndApellido2AndDireccionAndTfno(nombre, apellido1, apellido2, direccion, tfno).isEmpty()){
			return repository.findByNombreAndApellido1AndApellido2AndDireccionAndTfno(nombre, apellido1, apellido2, direccion, tfno);
		}else {
			throw new EntityNotFoundException("El cliente con esos datos no existe.");
		}
	}
	

}
