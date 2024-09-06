package com.P1.Proyecto1Ruben_back.providerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.entity.TiendaEntity;
import com.P1.Proyecto1Ruben_back.provider.TiendaProvider;
import com.P1.Proyecto1Ruben_back.repository.TiendaRepository;

@Service
public class TiendaProviderImpl implements TiendaProvider {
	
	@Autowired
	private TiendaRepository repository;

	@Override
	public TiendaEntity findTiendaById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public TiendaEntity createTienda(TiendaEntity tienda) {
		return repository.save(tienda);
	}

	@Override
	public TiendaEntity updateTienda(TiendaEntity tienda) {
		return repository.save(tienda);
	}

	@Override
	public void deleteTiendaById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<TiendaEntity> allTiendas() {
		return repository.findAll();
	}

}
