package com.P1.Proyecto1Ruben_back.repository;

import org.springframework.stereotype.Repository;

import com.P1.Proyecto1Ruben_back.entity.VentaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Long>{

}
