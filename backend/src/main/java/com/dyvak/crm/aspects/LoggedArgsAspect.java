package com.dyvak.crm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LoggedArgsAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Before(value = "@annotation(com.dyvak.crm.aspects.LoggedArgs)")
    public void loggedArgsExecution(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        Map<String, String> typeValue = new HashMap<>();
        for (Object obj : args) {
            if (obj != null) {
                typeValue.put(obj.getClass().getName(), obj.toString());
            }
        }
        log.info("{} Parameter ->  {}", joinPoint.getSignature().getName(), typeValue);
    }
}
