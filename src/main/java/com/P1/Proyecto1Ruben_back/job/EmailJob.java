package com.P1.Proyecto1Ruben_back.job;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.P1.Proyecto1Ruben_back.provider.EmailProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailJob extends QuartzJobBean{
	
	@Autowired
	private EmailProvider emailService;


	@Override
	protected void executeInternal(JobExecutionContext context){
		String to = "rubengarciaeguizabal23@gmail.com";
        String subject = "Notificación Programada";
        String text = "Este es un correo programado.";

        emailService.sendEmail(to, subject, text);
        log.info("Correo enviado exitosamente!");
	}

}
