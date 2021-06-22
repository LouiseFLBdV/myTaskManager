package com.stefanini.taskmanager.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

//todo de folosit
@Aspect
public class SendEmailAspect {
    @AfterReturning("execution(* com.stefanini.taskmanager.service.Service.create(..))")
    public void afterServiceSaveAdvice(){
    }
}
