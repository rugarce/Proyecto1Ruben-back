package com.P1.Proyecto1Ruben_back.repository;

import org.springframework.stereotype.Repository;

import com.P1.Proyecto1Ruben_back.entity.TiendaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TiendaRepository extends JpaRepository<TiendaEntity, Long> {

}
