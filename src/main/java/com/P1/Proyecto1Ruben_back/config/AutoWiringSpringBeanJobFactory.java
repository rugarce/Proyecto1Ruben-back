package com.P1.Proyecto1Ruben_back.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class AutoWiringSpringBeanJobFactory extends SpringBeanJobFactory {
	private AutowireCapableBeanFactory beanFactory;

    /**
     * Establece el contexto de la aplicacion de Spring.
     *
     * @param context el contexto de la aplicacion de Spring.
     */
    @Override
    public void setApplicationContext(final ApplicationContext context) {
        beanFactory = context.getAutowireCapableBeanFactory();
    }

    /**
     * Crea una instancia del job y la autowirea usando el contexto de Spring.
     *
     * @param bundle el paquete de activacion del trabajo.
     * @return una instancia de trabajo autowireada.
     * @throws Exception si ocurre un error durante la creacion de la instancia del trabajo.
     */
    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }

}
