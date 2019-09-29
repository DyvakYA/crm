package com.dyvak.crm.service.notification;

import java.util.List;

public interface NotificationService {

    void notify(String to, String subject, String text);

    void setMessenger(Messenger messenger);

    void setMessengers(List<Messenger> messengers);
}
