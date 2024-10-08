package com.P1.Proyecto1Ruben_back.config;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.P1.Proyecto1Ruben_back.job.EmailJob;

@Configuration
public class AppConfig {

	@Bean
	ModelMapper ModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
    SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();

        Trigger[] triggers = configureTriggers();

        scheduler.setTriggers(triggers);
        return scheduler;
    }
	private Trigger[] configureTriggers() {
		List<Trigger> triggers = new ArrayList<>();
		triggers.add(cronEmailJobFactoryBean().getObject());
		return triggers.toArray(new Trigger[0]);
	}
	
	@Bean
    CronTriggerFactoryBean cronEmailJobFactoryBean() {
        CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
        stFactory.setJobDetail(EmailJobFactoryBean().getObject());
        stFactory.setCronExpression("0 0/1 * * * ?");
        return stFactory;
    }

    @Bean
    JobDetailFactoryBean EmailJobFactoryBean() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(EmailJob.class);
        factory.setDurability(true);
        return factory;
    }
}
