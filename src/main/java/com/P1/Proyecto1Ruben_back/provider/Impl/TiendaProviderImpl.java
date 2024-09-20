package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.dto.TiendaDto;
import com.P1.Proyecto1Ruben_back.entity.TiendaEntity;
import com.P1.Proyecto1Ruben_back.provider.TiendaProvider;
import com.P1.Proyecto1Ruben_back.repository.TiendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TiendaProviderImpl implements TiendaProvider {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private TiendaRepository repository;

	@Override
	public TiendaEntity findTiendaById(Long id) {
		return repository.findById(id).orElseThrow( () -> new EntityNotFoundException("La tienda con ID " + id + " no existe."));
	}

	@Override
	public TiendaEntity createTienda(TiendaDto tienda) {
		TiendaEntity tiendaEntity= modelMapper.map(tienda, TiendaEntity.class);
		return repository.save(tiendaEntity);
	}

	@Override
	public TiendaEntity updateTienda(Long id, TiendaDto tienda) {
		TiendaEntity tiendaEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("La tienda con ID " + id + " no existe."));
		TiendaEntity tiendaActualizada= modelMapper.map(tienda, TiendaEntity.class);
		tiendaEntity.setNombre(tiendaActualizada.getNombre());
		tiendaEntity.setDireccion(tiendaActualizada.getDireccion());
		return repository.save(tiendaEntity);
	}

	@Override
	public void deleteTiendaById(Long id) {
		repository.findById(id).orElseThrow( () -> new EntityNotFoundException("La tienda con ID " + id + " no existe."));
		repository.deleteById(id);
	}

	@Override
	public List<TiendaEntity> allTiendas() {
		return repository.findAll();
	}

}
