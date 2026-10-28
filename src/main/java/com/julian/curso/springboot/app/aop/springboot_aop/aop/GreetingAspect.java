package com.julian.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component 
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Pointcut expression to match all methods in GreetingService
    //@Before("execution(* com.julian.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    
    // Pointcut expression to match all methods in the services package
    //@Before("execution(* com.julian.curso.springboot.app.aop.springboot_aop.services.*.*(..))")
    
    // Pointcut expression to match all methods in the com.julian.curso.springboot.app.aop.springboot_aop package and its sub-packages
    //@Before("execution(* com.julian.curso.springboot.app.aop.springboot_aop..*.*(..))")
    
    // Pointcut expression to match the sayHello method in GreetingService
    @Before("execution(* com.julian.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint) {

        String method  = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before method: {} with arguments: {}",method, args);
    }


    @After("execution(* com.julian.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    public void loggerAfter(JoinPoint joinPoint) {

        String method  = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After method: {} with arguments: {}",method, args);
    }

    @AfterReturning ("execution(* com.julian.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    public void loggerAfterReturning(JoinPoint joinPoint) {

        String method  = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After returning from method: {} with arguments: {}",method, args);
    }

    @AfterThrowing ("execution(* com.julian.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHelloError(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint) {

        String method  = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After throwing exception from method: {} with arguments: {}",method, args);
    }

    @Around("execution(* com.julian.curso.springboot.app.aop.springboot_aop.services.*.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try{
            logger.info("Around before method: {} with arguments: {}",method, args);
            result = joinPoint.proceed();
            logger.info("Around after method: {} with return value: {}",method, result);
            return result;
        }
        catch (Throwable e){
            logger.error("Exception in method: {} with arguments: {}. Exception: {}", method, args, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
