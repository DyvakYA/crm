package com.dyvak.springbootvuejs.configuration;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@RequiredArgsConstructor
public class FreeCrmListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(FreeCrmListener.class);

    private final NotificationProperties notificationProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        notificationProperties.getEmail().forEach(s -> log.info("Send message to -> {}", s));
    }
}
