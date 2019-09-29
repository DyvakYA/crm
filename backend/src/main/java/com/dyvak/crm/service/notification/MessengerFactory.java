package com.dyvak.crm.service.notification;

public interface MessengerFactory {

    Messenger getMessenger(String selector);
}
