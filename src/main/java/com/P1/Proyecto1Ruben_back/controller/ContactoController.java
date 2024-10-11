package com.P1.Proyecto1Ruben_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.P1.Proyecto1Ruben_back.dto.ContactoDto;
import com.P1.Proyecto1Ruben_back.dto.MessageResponseDto;
import com.P1.Proyecto1Ruben_back.provider.EmailProvider;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ContactoController {
	@Autowired
	private EmailProvider emailService;

	@PostMapping(value = "/enviar-mail")
	public MessageResponseDto<String> enviarCorreo(@RequestBody ContactoDto contacto) {
		try {
			log.info("Correo: ", contacto.getCorreo());
			log.info("Asunto: ", contacto.getAsunto());
			log.info("Mensaje:", contacto.getMensaje());
			emailService.sendEmail(contacto.getCorreo(), contacto.getAsunto(),contacto.getMensaje());
			return MessageResponseDto.success("Correo enviado");
		} catch (Exception e) {
			log.info("Error", e);
			return MessageResponseDto.fail("Se ha producido un error");
		}
	}
	
	@PostMapping(value = "/enviar-mailAdjunto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public MessageResponseDto<String> enviarCorreoAdjunto(@RequestParam String correo, 
			@RequestParam String nombre,
			@RequestParam String asunto, 
	        @RequestParam String mensaje,
	        @RequestParam List<MultipartFile> attachments) {
		try {
			log.info("Correo con archivos adjuntos");
			emailService.sendEmailWithAttach(correo, asunto,mensaje,attachments);
			return MessageResponseDto.success("Correo enviado");
		} catch (Exception e) {
			log.info("Error", e);
			return MessageResponseDto.fail("Se ha producido un error");
		}
	}
}
