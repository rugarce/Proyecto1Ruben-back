package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.ArrayList;
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
public class ClienteProviderImpl implements ClienteProvider {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ClienteDto findClienteById(Long id) {
		ClienteEntity clienteEntity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("El cliente con ID " + id + " no existe."));
		ClienteDto clienteDto = modelMapper.map(clienteEntity, ClienteDto.class);
		return clienteDto;
	}

	@Override
	public Long createCliente(ClienteDto cliente) {
		ClienteEntity clienteEntity = modelMapper.map(cliente, ClienteEntity.class);
		repository.save(clienteEntity);
		return clienteEntity.getId();
	}

	@Override
	public ClienteDto updateCliente(ClienteDto cliente) {
		ClienteEntity clienteEntity = repository.findById(cliente.getId())
				.orElseThrow(() -> new EntityNotFoundException("El cliente con ID " + cliente.getId() + " no existe."));
		modelMapper.map(cliente, clienteEntity);
		repository.save(clienteEntity);
		return cliente;
	}

	@Override
	public void deleteClienteById(Long id) {
		if(id==null) {
			throw new IllegalArgumentException ("El id no puede ser nulo.");
		}
		repository.deleteById(id);
	}

	@Override
	public List<ClienteDto> allClients() {
		List<ClienteEntity> listaEntity = repository.findAll();
		return listaEntityAlistaDto(listaEntity);
	}

	@Override
	public List<ClienteDto> findClienteByName(String name) {
		if (repository.findByName(name).isEmpty()) {
			throw new EntityNotFoundException("El cliente con nombre " + name + " no existe.");
		}
		List<ClienteEntity> listclienteEntity = repository.findByName(name);
		return listaEntityAlistaDto(listclienteEntity);
	}

	@Override
	public List<ClienteDto> buscarClientes(String nombre, String apellido1, String apellido2, String direccion,
			String tfno) {
		if (repository.findByNombreAndApellido1AndApellido2AndDireccionAndTfno(nombre, apellido1, apellido2, direccion, tfno).isEmpty()) {
			throw new EntityNotFoundException("El cliente con esos datos no existe.");
		}
		List<ClienteEntity> listclienteEntity = repository.findByNombreAndApellido1AndApellido2AndDireccionAndTfno(nombre, apellido1, 
				apellido2, direccion, tfno);
		return listaEntityAlistaDto(listclienteEntity);
	}
	
	public List<ClienteDto> listaEntityAlistaDto(List<ClienteEntity> listaEntity) {
		List<ClienteDto> listaDto = new ArrayList<ClienteDto>();
		for (ClienteEntity l : listaEntity) {
			ClienteDto clienteDto = modelMapper.map(l, ClienteDto.class);
			listaDto.add(clienteDto);
		}
		return listaDto;
	}
}
