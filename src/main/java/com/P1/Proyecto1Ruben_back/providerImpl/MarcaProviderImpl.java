package com.P1.Proyecto1Ruben_back.providerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.P1.Proyecto1Ruben_back.entity.MarcaEntity;
import com.P1.Proyecto1Ruben_back.provider.MarcaProvider;
import com.P1.Proyecto1Ruben_back.repository.MarcaRepository;

@Service
public class MarcaProviderImpl implements MarcaProvider {
	
	@Autowired
	private MarcaRepository repository;

	@Override
	public MarcaEntity findMarcaById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public MarcaEntity createMarca(MarcaEntity marca) {
		return repository.save(marca);
	}

	@Override
	public MarcaEntity updateMarca(MarcaEntity marca) {
		// TODO Auto-generated method stub
		return repository.save(marca);
	}

	@Override
	public void deleteMarcaById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<MarcaEntity> allMarcas() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	


}
