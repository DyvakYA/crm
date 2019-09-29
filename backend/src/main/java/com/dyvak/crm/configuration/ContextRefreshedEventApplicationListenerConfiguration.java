package com.dyvak.crm.configuration;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@RequiredArgsConstructor
public class ContextRefreshedEventApplicationListenerConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(ContextRefreshedEventApplicationListenerConfiguration.class);

    private final NotificationProperties notificationProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        notificationProperties.getEmail().forEach(s -> log.info("Send message about context refreshed to -> {}", s));
    }
}
