package com.dyvak.crm.service.notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sms")
public class SMSMessenger implements Messenger{

    @Override
    public void notify(String to, String subject, String text) {
        System.out.println("send email");


    }
}
