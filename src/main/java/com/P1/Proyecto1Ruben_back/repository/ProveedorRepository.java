package com.P1.Proyecto1Ruben_back.repository;

import org.springframework.stereotype.Repository;

import com.P1.Proyecto1Ruben_back.entity.ProveedorEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long>{

}