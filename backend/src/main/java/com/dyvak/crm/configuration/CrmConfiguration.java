package com.dyvak.crm.configuration;

import com.dyvak.crm.configuration.conditional.ConditionalOnNotification;
import com.dyvak.crm.configuration.conditional.ConditionalOnProduction;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(NotificationProperties.class)
public class CrmConfiguration {

    @Bean
    @ConditionalOnProduction
    @ConditionalOnNotification
    @ConditionalOnMissingBean
    public ContextRefreshedEventApplicationListenerConfiguration onApplicationStartListener(NotificationProperties properties) {
        return new ContextRefreshedEventApplicationListenerConfiguration(properties);
    }

    @Bean
    @ConditionalOnProduction
    @ConditionalOnNotification
    @ConditionalOnMissingBean
    public ContextClosedEventApplicationListenerConfiguration onApplicationStopListener(NotificationProperties properties) {
        return new ContextClosedEventApplicationListenerConfiguration(properties);
    }


}
