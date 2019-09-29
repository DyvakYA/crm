package com.dyvak.crm.service.notification;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("email")
@AllArgsConstructor
public class EmailMessenger implements Messenger {

    private JavaMailSender emailSender;

    @Override
    public void notify(String to, String subject, String text) {

        System.out.println("Send email");
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        emailSender.send(message);
    }
}
