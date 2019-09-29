package com.dyvak.crm.service.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    private List<String> messengers = new ArrayList<>();

    private String to;
    private String subject;
    private String text;
}
