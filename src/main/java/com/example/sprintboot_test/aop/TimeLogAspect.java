package com.example.sprintboot_test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLogAspect {

    @Pointcut("@annotation(com.example.sprintboot_test.annotation.TimeLog)")
    public void timeLogAnnotationPointcut() {
    }

    @Around("timeLogAnnotationPointcut()")
    public Object timeLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println(joinPoint.getSignature() + " executed in " + duration + "ms");

        return result;
    }
}
