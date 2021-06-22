package com.stefanini.taskmanager.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger();

    @Before("execution(public * get(..))")
    public void beforeDaoGetAdvice(){
        logger.info("Try to get - done");
    }

    @Before("execution(public * getAll(..))")
    public void beforeDaoGetAllAdvice(){
        logger.info("Try to getAll - done");
    }
    @Before("execution(public * getByCriteria(..))")
    public void beforeDaoGetByCriteriaAdvice(){
        logger.info("Try to getByCriteria - done");
    }

    @Before("execution(public * com.stefanini.taskmanager.service.Service.create(..))")
    public void beforeDaoCreateAdvice(){
        logger.info("Try to create - done");
    }
    @Before("execution(public * checkTransaction(..))")
    public void beforeDaoCheckTransactionAdvice(){
        logger.info("Try to begin session - done");
    }

    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "exception")
    public void afterThrowingLogError(Throwable exception) {
        System.out.println("lel");
        logger.error("We have error: ");
    }
}