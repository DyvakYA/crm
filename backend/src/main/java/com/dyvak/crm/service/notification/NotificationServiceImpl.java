package com.dyvak.crm.service.notification;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private List<Messenger> messengers;

    @PostConstruct
    public void init() {
        messengers = new ArrayList<>();
    }

    @Override
    public void notify(String to, String subject, String text) {
        messengers.stream()
                .forEach(messenger -> messenger.notify(to, subject, text));
    }

    @Override
    public void setMessenger(Messenger messenger) {
        messengers.add(messenger);
    }

    @Override
    public void setMessengers(List<Messenger> messengers) {
        this.messengers = messengers;
    }
}
