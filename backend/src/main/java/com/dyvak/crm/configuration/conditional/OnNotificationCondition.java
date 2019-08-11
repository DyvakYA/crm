package com.dyvak.springbootvuejs.configuration.conditional;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

public class OnNotificationCondition extends AllNestedConditions {

    public OnNotificationCondition() {
        super(REGISTER_BEAN);
    }

    @ConditionalOnProperty("notification.email")
    public static class OnDistinationCondition {

    }

    @ConditionalOnProperty(value = "notification.activate", havingValue = "true")
    public static class OnEnabledCondition {


    }

}
