package com.dyvak.crm.service.notification;

import java.util.HashMap;
import java.util.Map;

public enum MessengerType {

    EMAIL("email"),
    SMS("sms");

    private static final Map<String, MessengerType> map = new HashMap<>();

    static {
        for (MessengerType type : values()) {
            map.put(type.getName(), type);
        }
    }

    private String name;

    MessengerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MessengerType getValue(String name) {
        return map.get(name);
    }
}
