package com.dyvak.crm.controller;

import com.dyvak.crm.service.notification.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NotificationController {

    private MessengerFactory messengerFactory;

    private NotificationService notificationService;

    @RequestMapping(path = "/notification/send", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> sendNotification(@RequestBody Notification notification) {
        List<Messenger> messengers = this.getMessengers(notification.getMessengers());
        notificationService.setMessengers(messengers);
        String to = notification.getTo();
        String subject = notification.getSubject();
        String text = notification.getText();
        notificationService.notify(to, subject, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private List<Messenger> getMessengers(List<String> messengers) {
        return messengers.stream()
                .filter(messenger -> Arrays.asList(MessengerType.values()).contains(MessengerType.getValue(messenger)))
                .map(messenger -> messengerFactory.getMessenger(messenger))
                .collect(Collectors.toList());
    }
}
