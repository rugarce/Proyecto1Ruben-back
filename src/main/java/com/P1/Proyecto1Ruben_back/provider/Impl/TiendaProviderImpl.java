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
	public TiendaDto updateTienda(Long id, TiendaDto tienda) {
		TiendaEntity tiendaEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("La tienda con ID " + id + " no existe."));
		TiendaEntity tiendaActualizada= modelMapper.map(tienda, TiendaEntity.class);
		tiendaEntity.setNombre(tiendaActualizada.getNombre());
		tiendaEntity.setDireccion(tiendaActualizada.getDireccion());
		repository.save(tiendaEntity);
		return tienda= modelMapper.map(tiendaEntity, TiendaDto.class);
	}

	@Override
	public void deleteTiendaById(Long id) {
		repository.findById(id).orElseThrow( () -> new EntityNotFoundException("La tienda con ID " + id + " no existe."));
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
