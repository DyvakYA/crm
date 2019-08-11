package com.dyvak.springbootvuejs.configuration;

import com.dyvak.springbootvuejs.configuration.conditional.ConditionalOnNotification;
import com.dyvak.springbootvuejs.configuration.conditional.ConditionalOnProduction;
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
    public FreeCrmListener notificationListener(NotificationProperties properties) {
        return new FreeCrmListener(properties);
    }


}
