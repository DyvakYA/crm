package com.dyvak.crm.service.notification;

public interface Messenger {

    void notify(String to, String subject, String text);

}
