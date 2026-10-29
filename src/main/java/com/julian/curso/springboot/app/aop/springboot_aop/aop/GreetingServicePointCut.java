package com.julian.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect 
@Component 
public class GreetingServicePointCut {

    // Pointcut expression to match all methods in GreetingService for define a pointcut in the aspect class

    @Pointcut("execution(* com.julian.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut(){

    }

    @Pointcut ("execution(* com.julian.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingFooLoggerPointCut(){

    }
}
