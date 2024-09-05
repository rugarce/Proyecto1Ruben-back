package com.P1.Proyecto1Ruben_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	@Query("SELECT c FROM ClienteEntity c WHERE c.nombre = :nombre")
	List<ClienteEntity> findByName(@Param("nombre") String name);
	
}
