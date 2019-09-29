package com.dyvak.crm.service.notification;

public interface NotificationService {

    void notify(String to, String subject, String text);

    void setMessenger(Messenger messenger);
}
