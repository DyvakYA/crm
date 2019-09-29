package com.dyvak.crm.configuration;

import com.dyvak.crm.service.notification.MessengerFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceFactoryConfiguration {

    @Bean
    public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean serviceLocatorFactory = new ServiceLocatorFactoryBean();
        serviceLocatorFactory.setServiceLocatorInterface(MessengerFactory.class);
        return serviceLocatorFactory;
    }

    @Bean
    public MessengerFactory messengerFactory() {
        return (MessengerFactory) serviceLocatorFactoryBean().getObject();
    }
}
