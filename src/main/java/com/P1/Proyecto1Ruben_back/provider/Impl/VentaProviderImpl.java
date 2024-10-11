package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.dto.VentaDto;
import com.P1.Proyecto1Ruben_back.entity.VentaEntity;
import com.P1.Proyecto1Ruben_back.provider.VentaProvider;
import com.P1.Proyecto1Ruben_back.repository.VentaRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class VentaProviderImpl implements VentaProvider {
	
	@Autowired
	private VentaRepository repository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public VentaDto findVentaById(Long id) {
		VentaEntity ventaEntity = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + id + " no existe."));
		VentaDto ventaDto =  modelMapper.map(ventaEntity, VentaDto.class);
		return ventaDto;
	}

	@Override
	public Long createVenta(VentaDto venta) {
		VentaEntity ventaEntity = modelMapper.map(venta, VentaEntity.class);
		ventaEntity = repository.save(ventaEntity);
		return ventaEntity.getId();
	}

	@Override
	public VentaDto updateVenta(VentaDto venta) {
		VentaEntity ventaEntity = repository.findById(venta.getId()).orElseThrow( () -> new EntityNotFoundException("El producto con ID " + venta.getId() + " no existe."));
		modelMapper.map(venta, ventaEntity);
		repository.save(ventaEntity);
		return venta;
	}

	@Override
	public void deleteVentaById(Long id) {
		if(id==null) {
			throw new IllegalArgumentException ("El id no puede ser nulo.");
		}
		repository.deleteById(id);
	}

	@Override
	public List<VentaDto> allVentas() {
		List<VentaEntity> listaEntity = repository.findAll();
		List<VentaDto> listaDto = new ArrayList<VentaDto>();
		for(VentaEntity l :listaEntity) {
			VentaDto ventaDto = modelMapper.map(l, VentaDto.class);
			listaDto.add(ventaDto);
		}
		return listaDto;
	}

}
