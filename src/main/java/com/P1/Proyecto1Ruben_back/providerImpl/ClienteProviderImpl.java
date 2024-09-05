package com.P1.Proyecto1Ruben_back.providerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;
import com.P1.Proyecto1Ruben_back.provider.ClienteProvider;
import com.P1.Proyecto1Ruben_back.repository.ClienteRepository;

@Service
public class ClienteProviderImpl implements ClienteProvider{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public ClienteEntity findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public ClienteEntity create(ClienteEntity cliente) {
		return repository.save(cliente);
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
	

}
