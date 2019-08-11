package com.dyvak.springbootvuejs.configuration.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

public class OnProductionCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String[] profiles = conditionContext.getEnvironment().getActiveProfiles();
        return profiles.length > 0 && Arrays.asList(profiles).contains("production") ? true : false;
    }
}
