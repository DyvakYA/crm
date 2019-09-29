package com.dyvak.crm.configuration.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnNotificationCondition.class)
public @interface ConditionalOnNotification {
}
