package com.P1.Proyecto1Ruben_back.provider.Impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.P1.Proyecto1Ruben_back.provider.EmailProvider;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailProviderImpl implements EmailProvider {
	@Autowired
    private JavaMailSender emailSender;
	

	@Override
	public void sendEmail(String to, String subject, String text) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setFrom("perezperezrodolfo550@gmail.com");
	        helper.setSubject(subject);
	        helper.setText(text);
		}catch(MessagingException e) {
			log.info("Error", e);
		}
		
        emailSender.send(message);
	}

	@Override
	public void sendEmailWithAttach(String to, String subject, String text, List<MultipartFile> attachments) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setFrom("perezperezrodolfo550@gmail.com");
	        helper.setSubject(subject);
	        helper.setText(text);   
	        
	        if(attachments!=null &&!attachments.isEmpty()) {
	        	for (MultipartFile attachment : attachments) {
	        		byte[] attachmentBytes = attachment.getBytes();
		        	String filename = attachment.getOriginalFilename();
		        	Resource resource = new ByteArrayResource(attachmentBytes);
		        	helper.addAttachment(filename,resource);
	        	}
	        }
	    }catch(MessagingException e) {
	        	log.info("Error", e);
	        	} catch (IOException e) {
	        		log.info("Error", e);
	        		}
		emailSender.send(message);
	}
}
