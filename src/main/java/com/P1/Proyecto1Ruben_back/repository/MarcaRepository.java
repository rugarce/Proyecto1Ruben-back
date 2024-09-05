package com.P1.Proyecto1Ruben_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.P1.Proyecto1Ruben_back.entity.MarcaEntity;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Long>{

}
