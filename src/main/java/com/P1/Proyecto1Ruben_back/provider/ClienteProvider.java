package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.dto.ClienteDto;
import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;

public interface ClienteProvider {
	ClienteEntity findById(Long id);
	List<ClienteEntity> findByName(String name);
	ClienteEntity create(ClienteDto cliente);
	ClienteEntity update(ClienteEntity cliente);
    void deleteById(Long id);
    public List<ClienteEntity> allClients();
}
