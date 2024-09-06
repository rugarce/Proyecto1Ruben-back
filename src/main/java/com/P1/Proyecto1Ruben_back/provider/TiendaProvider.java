package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import com.P1.Proyecto1Ruben_back.entity.TiendaEntity;

public interface TiendaProvider {
	TiendaEntity findTiendaById(Long id);
	TiendaEntity createTienda(TiendaEntity tienda);
	TiendaEntity updateTienda(TiendaEntity tienda);
    void deleteTiendaById(Long id);
    public List<TiendaEntity> allTiendas();
}
