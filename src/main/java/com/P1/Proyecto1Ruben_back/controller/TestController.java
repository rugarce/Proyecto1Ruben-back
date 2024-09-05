package com.P1.Proyecto1Ruben_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	public String hola() {
		return "Hola";
	}
}
