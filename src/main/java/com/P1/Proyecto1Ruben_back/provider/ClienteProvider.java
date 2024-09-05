package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;

public interface ClienteProvider {
	ClienteEntity findById(Long id);
	ClienteEntity create(ClienteEntity cliente);
	ClienteEntity update(ClienteEntity cliente);
    void deleteById(Long id);
    public List<ClienteEntity> allClients();
}
