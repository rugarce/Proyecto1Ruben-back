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
public class ClienteProviderImpl implements ClienteProvider{
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ClienteDto findClienteById(Long id) {
		ClienteEntity clienteEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El cliente con ID " + id + " no existe."));
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
	public ClienteDto updateCliente(Long id, ClienteDto cliente) {
		ClienteEntity clienteEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El cliente con ID " + id + " no existe."));
		ClienteEntity clienteActualizado = modelMapper.map(cliente, ClienteEntity.class);
		clienteEntity.setNombre(clienteActualizado.getNombre());
		clienteEntity.setApellido1(clienteActualizado.getApellido1());
		clienteEntity.setApellido2(clienteActualizado.getApellido2());
		clienteEntity.setDireccion(clienteActualizado.getDireccion());
		clienteEntity.setTfno(clienteActualizado.getTfno());
		repository.save(clienteEntity);
		return cliente = modelMapper.map(clienteEntity, ClienteDto.class);
	}

	@Override
	public void deleteClienteById(Long id) {
		repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El cliente con ID " + id + " no existe."));
		repository.deleteById(id);
	}

	@Override
	public List<ClienteDto> allClients() {
		List<ClienteEntity> listaEntity = repository.findAll();
		List<ClienteDto> listaDto = new ArrayList<ClienteDto>();
		for(ClienteEntity l :listaEntity) {
			ClienteDto clienteDto = modelMapper.map(l, ClienteDto.class);
			listaDto.add(clienteDto);
		}
		return listaDto;
	}

	@Override
	public List<ClienteDto> findClienteByName(String name) {
		if(!repository.findByName(name).isEmpty()){
			List<ClienteEntity> listclienteEntity= repository.findByName(name);
			List<ClienteDto> listaDto = new ArrayList<ClienteDto>();
			for(ClienteEntity l :listclienteEntity) {
				ClienteDto clienteDto = modelMapper.map(l, ClienteDto.class);
				listaDto.add(clienteDto);
			}
			return listaDto;
		}else {
			throw new EntityNotFoundException("El cliente con nombre " + name + " no existe.");
		}
		
	}

	@Override
	public List<ClienteDto> buscarClientes(String nombre, String apellido1, String apellido2, String direccion,
			String tfno) {
		if(!repository.findByNombreAndApellido1AndApellido2AndDireccionAndTfno(nombre, apellido1, apellido2, direccion, tfno).isEmpty()){
			List<ClienteEntity> listclienteEntity= repository.findByNombreAndApellido1AndApellido2AndDireccionAndTfno(nombre, apellido1, apellido2, direccion, tfno);
			List<ClienteDto> listaDto = new ArrayList<ClienteDto>();
			for(ClienteEntity l :listclienteEntity) {
				ClienteDto clienteDto = modelMapper.map(l, ClienteDto.class);
				listaDto.add(clienteDto);
			}
			return listaDto;
		}else {
			throw new EntityNotFoundException("El cliente con esos datos no existe.");
		}
	}
	

}
