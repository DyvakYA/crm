package com.dyvak.crm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LoggedAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Before(value = "@annotation(com.dyvak.crm.aspects.LoggedReturn)")
    public void loggedArgsExecution(JoinPoint joinPoint) {

        if (log.isDebugEnabled()) {
            Object[] args = joinPoint.getArgs();
            Map<String, String> typeValue = new HashMap<>();
            for (Object obj : args) {
                if (obj != null) {
                    typeValue.put(obj.getClass().getName(), obj.toString());
                }
            }
            log.debug("{} Parameter ->  {}", joinPoint.getSignature().getName(), typeValue);
        }
    }

    @AfterReturning(value = "@annotation(com.dyvak.crm.aspects.LoggedReturn)", returning = "returnValue")
    public void loggedResultExecution(JoinPoint joinPoint, Object returnValue){
        log.info("{} return value {}", joinPoint.getSignature(), returnValue);
    }
}
