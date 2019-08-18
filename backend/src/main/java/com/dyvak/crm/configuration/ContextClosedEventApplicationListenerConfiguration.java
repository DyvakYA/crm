package com.dyvak.crm.configuration.conditional;

import com.dyvak.crm.configuration.NotificationProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@RequiredArgsConstructor
public class ContextClosedEventApplicationListenerConfiguration implements ApplicationListener<ContextClosedEvent> {

    private static final Logger log = LoggerFactory.getLogger(com.dyvak.crm.configuration.ContextRefreshedEventContextListenerConfiguration.class);

    private final NotificationProperties notificationProperties;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        notificationProperties.getEmail().forEach(s -> log.info("Send message about close context to -> {}", s));
    }
}

