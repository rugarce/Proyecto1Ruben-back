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

import com.P1.Proyecto1Ruben_back.entity.MarcaEntity;
import com.P1.Proyecto1Ruben_back.provider.MarcaProvider;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	@Autowired
	private MarcaProvider provider;
	
	@GetMapping("/all")
	public List<MarcaEntity> allMarcas(){
		return provider.allMarcas();
	}
	
	@GetMapping("/{id}")
	public MarcaEntity findById(@PathVariable Long id) {
		return provider.findMarcaById(id);
	}
	
	@PostMapping("/create")
	public MarcaEntity createPerson(@RequestBody MarcaEntity marca) {
		return provider.createMarca(marca);
	}
	
	@PutMapping("/update/{id}")
	public MarcaEntity updatePerson(@PathVariable int id ,@RequestBody MarcaEntity marca) {
		return provider.updateMarca(marca);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable Long id) {
		provider.deleteMarcaById(id);
	}
}
