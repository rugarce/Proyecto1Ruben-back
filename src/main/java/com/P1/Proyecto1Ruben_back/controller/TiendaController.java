package com.P1.Proyecto1Ruben_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.P1.Proyecto1Ruben_back.entity.TiendaEntity;
import com.P1.Proyecto1Ruben_back.provider.TiendaProvider;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/tienda")
public class TiendaController {
	@Autowired
	private TiendaProvider provider;
	
	@GetMapping("/all")
	public List<TiendaEntity> allTiendas(){
		return provider.allTiendas();
	}
	
	@GetMapping("/nombre/{nombre}")
	public TiendaEntity findById(@PathVariable Long id) {
		return provider.findTiendaById(id);
	}
	
	@PostMapping("/create")
	public TiendaEntity createPerson(@RequestBody TiendaEntity tienda) {
		return provider.createTienda(tienda);
	}
	
	@PutMapping("/update/{id}")
	public TiendaEntity updatePerson(@PathVariable int id ,@RequestBody TiendaEntity tienda) {
		return provider.updateTienda(tienda);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable Long id) {
		provider.deleteTiendaById(id);
	}
}
