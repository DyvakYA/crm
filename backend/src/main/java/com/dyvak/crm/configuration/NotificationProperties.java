package com.dyvak.crm.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties("notification")
public class NotificationProperties {

    boolean activate;

    List<String> email;

}
