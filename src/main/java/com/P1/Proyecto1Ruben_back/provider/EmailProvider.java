package com.P1.Proyecto1Ruben_back.provider;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface EmailProvider {
	public void sendEmail(String to, String subject, String text);
	public void sendEmailWithAttach(String to, String subject, String text, List<MultipartFile> attachments);
}
