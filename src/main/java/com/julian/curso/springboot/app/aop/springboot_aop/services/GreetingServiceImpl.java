package com.julian.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service 
public class GreetingServiceImpl implements GreetingService{

    @Override
    public String sayHello(String person, String pharse) {
        String greeting = pharse + " " + person;
        System.out.println(greeting);
        return greeting;
    }

    @Override
    public String sayHelloError(String person, String pharse) {
        throw new RuntimeException("Error occurred while saying hello");
    }
}