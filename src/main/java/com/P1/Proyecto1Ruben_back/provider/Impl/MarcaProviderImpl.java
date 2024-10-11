package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.ArrayList;
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

	public MarcaDto findMarcaById(Long id) {
		MarcaEntity marcaEntity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("La marca con ID " + id + " no existe."));
		MarcaDto marcaDto = modelMapper.map(marcaEntity, MarcaDto.class);
		return marcaDto;
	}

	@Override
	public Long createMarca(MarcaDto marca) {
		MarcaEntity marcaEntity = modelMapper.map(marca, MarcaEntity.class);
		repository.save(marcaEntity);
		return marcaEntity.getId();
	}

	@Override
	public MarcaDto updateMarca(MarcaDto marca) {
		MarcaEntity marcaEntity = repository.findById(marca.getId())
				.orElseThrow(() -> new EntityNotFoundException("La marca con ID " + marca.getId() + " no existe."));
		modelMapper.map(marca, marcaEntity);
		repository.save(marcaEntity);
		return marca;
	}

	@Override
	public void deleteMarcaById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("El id no puede ser nulo.");
		}
		repository.deleteById(id);
	}

	@Override
	public List<MarcaDto> allMarcas() {
		List<MarcaEntity> listaEntity = repository.findAll();
		List<MarcaDto> listaDto = new ArrayList<MarcaDto>();
		for (MarcaEntity l : listaEntity) {
			MarcaDto marcaDto = modelMapper.map(l, MarcaDto.class);
			listaDto.add(marcaDto);
		}
		return listaDto;
	}

}
