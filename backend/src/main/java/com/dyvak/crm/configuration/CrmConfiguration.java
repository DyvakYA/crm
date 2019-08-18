package com.dyvak.crm.configuration;

import com.dyvak.crm.configuration.conditional.ConditionalOnNotification;
import com.dyvak.crm.configuration.conditional.ConditionalOnProduction;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(NotificationProperties.class)
public class FreeCrmConfiguration {

    @Bean
    @ConditionalOnProduction
    @ConditionalOnNotification
    @ConditionalOnMissingBean
    public ContextRefreshedEventApplicationListenerConfiguration notificationListener(NotificationProperties properties) {
        return new ContextRefreshedEventApplicationListenerConfiguration(properties);
    }

    @Bean
    @ConditionalOnProduction
    @ConditionalOnNotification
    @ConditionalOnMissingBean
    public ContextClosedEventContextListenerConfiguration notificationListener(NotificationProperties properties) {
        return new ContextRefreshedEventApplicationListenerConfiguration(properties);
    }


}
