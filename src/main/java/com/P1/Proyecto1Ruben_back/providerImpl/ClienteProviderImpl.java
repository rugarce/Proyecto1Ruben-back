package com.P1.Proyecto1Ruben_back.providerImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.dto.ClienteDto;
import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;
import com.P1.Proyecto1Ruben_back.provider.ClienteProvider;
import com.P1.Proyecto1Ruben_back.repository.ClienteRepository;

@Service
public class ClienteProviderImpl implements ClienteProvider{
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ClienteEntity findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public ClienteEntity create(ClienteDto cliente) {
		ClienteEntity clienteEntity = modelMapper.map(cliente, ClienteEntity.class);
		
		return repository.save(clienteEntity);
	}

	@Override
	public ClienteEntity update(ClienteEntity cliente) {
		return repository.save(cliente);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<ClienteEntity> allClients() {
		return repository.findAll();
	}

	@Override
	public List<ClienteEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}
	

}
