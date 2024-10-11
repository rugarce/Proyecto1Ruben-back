package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.ArrayList;
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
	public TiendaDto findTiendaById(Long id) {
		TiendaEntity tiendaEntity= repository.findById(id).orElseThrow( () -> new EntityNotFoundException("La tienda con ID " + id + " no existe."));
		TiendaDto tiendaDto= modelMapper.map(tiendaEntity, TiendaDto.class);
		return tiendaDto;
	}

	@Override
	public Long createTienda(TiendaDto tienda) {
		TiendaEntity tiendaEntity= modelMapper.map(tienda, TiendaEntity.class);
		repository.save(tiendaEntity);
		return tiendaEntity.getId();
	}

	@Override
	public TiendaDto updateTienda(TiendaDto tienda) {
		TiendaEntity tiendaEntity = repository.findById(tienda.getId()).orElseThrow( () -> new EntityNotFoundException("La tienda con ID " + tienda.getId() + " no existe."));
		modelMapper.map(tienda,tiendaEntity);
		repository.save(tiendaEntity);
		return tienda;
	}

	@Override
	public void deleteTiendaById(Long id) {
		if(id==null) {
			throw new IllegalArgumentException ("El id no puede ser nulo.");
		}
		repository.deleteById(id);
	}

	@Override
	public List<TiendaDto> allTiendas() {
		List<TiendaEntity> listaEntity = repository.findAll();
		List<TiendaDto> listaDto = new ArrayList<TiendaDto>();
		for(TiendaEntity l :listaEntity) {
			TiendaDto tiendaDto = modelMapper.map(l, TiendaDto.class);
			listaDto.add(tiendaDto);
		}
		return listaDto;
	}

}
