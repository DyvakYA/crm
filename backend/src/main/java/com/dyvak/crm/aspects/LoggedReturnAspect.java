package com.dyvak.crm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggedReturnAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(value = "@annotation(com.dyvak.crm.aspects.LoggedReturn)", returning = "returnValue")
    public void loggedResultExecution(JoinPoint joinPoint, Object returnValue) {
        log.info("{} return value {}", joinPoint.getSignature(), returnValue);
    }
}
