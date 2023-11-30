package com.thewhite.aoplesson.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@Order(1)
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("within(com.thewhite.aoplesson.service.*)")
    private void anyService() {
    }

    @Before("anyService()")
    public void showArgument(JoinPoint joinPoint) {
        String enterTime = LocalDateTime.now().format(ISO_LOCAL_DATE_TIME);
        joinPoint.getArgs();
        System.out.println(enterTime + ": call " + joinPoint.getSignature() + " with arguments " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("anyService()")
    public void printStackTrace() {
        new Throwable().printStackTrace();
    }

}
