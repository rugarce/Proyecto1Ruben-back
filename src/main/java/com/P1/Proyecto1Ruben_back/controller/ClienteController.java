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

import com.P1.Proyecto1Ruben_back.entity.ClienteEntity;
import com.P1.Proyecto1Ruben_back.provider.ClienteProvider;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteProvider provider;
	
	@GetMapping("/all")
	public List<ClienteEntity> allClients(){
		return provider.allClients();
	}
	
	@GetMapping("/nombre/{nombre}")
	public List<ClienteEntity> findByName(@PathVariable("nombre") String name) {
		return null;
	}
	
	@PostMapping("/create")
	public ClienteEntity createPerson(@RequestBody ClienteEntity cliente) {
		return provider.create(cliente);
	}
	
	@PutMapping("/update/{id}")
	public ClienteEntity updatePerson(@PathVariable int id ,@RequestBody ClienteEntity cliente) {
		return provider.update(cliente);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable Long id) {
		provider.deleteById(id);
	}
}
