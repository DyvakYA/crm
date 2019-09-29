package com.dyvak.crm.configuration;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@RequiredArgsConstructor
public class ContextClosedEventApplicationListenerConfiguration implements ApplicationListener<ContextClosedEvent> {

    private static final Logger log = LoggerFactory.getLogger(ContextClosedEventApplicationListenerConfiguration.class);

    private final NotificationProperties notificationProperties;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        notificationProperties.getEmail().forEach(s -> log.info("Send message about close context to -> {}", s));
    }
}

