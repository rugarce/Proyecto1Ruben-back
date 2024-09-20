package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.dto.MarcaDto;
import com.P1.Proyecto1Ruben_back.entity.MarcaEntity;
import com.P1.Proyecto1Ruben_back.provider.MarcaProvider;
import com.P1.Proyecto1Ruben_back.repository.MarcaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MarcaProviderImpl implements MarcaProvider {
	
	@Autowired
	private MarcaRepository repository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	
	public MarcaEntity findMarcaById(Long id) {
		return repository.findById(id).orElseThrow( () -> new EntityNotFoundException("La marca con ID " + id + " no existe."));
	}

	@Override
	public MarcaEntity createMarca(MarcaDto marca) {
		MarcaEntity marcaEntity = modelMapper.map(marca, MarcaEntity.class);
		return repository.save(marcaEntity);
	}

	@Override
	public MarcaEntity updateMarca(Long id, MarcaDto marca) {
		MarcaEntity marcaEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("La marca con ID " + id + " no existe."));
		MarcaEntity marcaActualizado = modelMapper.map(marca, MarcaEntity.class);
		marcaEntity.setNombre(marcaActualizado.getNombre());
		return repository.save(marcaEntity);
	}

	@Override
	public void deleteMarcaById(Long id) {
		repository.findById(id).orElseThrow( () -> new EntityNotFoundException("La marca con ID " + id + " no existe."));
		repository.deleteById(id);
	}

	@Override
	public List<MarcaEntity> allMarcas() {
		return repository.findAll();
	}
	


}
