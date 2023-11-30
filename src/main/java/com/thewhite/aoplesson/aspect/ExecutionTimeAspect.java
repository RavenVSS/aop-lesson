package com.thewhite.aoplesson.aspect;

import com.thewhite.aoplesson.annotation.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Around("@annotation(logExecutionTime)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        long before = System.currentTimeMillis();
        System.out.println("Start method");
        Object result = joinPoint.proceed();
        System.out.println("End method");
        long after = System.currentTimeMillis();

        long duration = after - before;

        long convertedDuration = logExecutionTime.outputFormat()
                                                 .convert(duration, MILLISECONDS);

        System.out.printf("""
                          ---
                          Method: %s
                          Time spend: %s %s
                          ---
                          """,
                          joinPoint.getSignature().toString(),
                          convertedDuration,
                          logExecutionTime.outputFormat().name());

        return result;
    }

}
