package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.entity.MarcaEntity;

public interface MarcaProvider {
	MarcaEntity findMarcaById(Long id);
	MarcaEntity createMarca(MarcaEntity marca);
	MarcaEntity updateMarca(MarcaEntity marca);
    void deleteMarcaById(Long id);
    public List<MarcaEntity> allMarcas();
}
