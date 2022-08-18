package com.axinalis.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {

    private Logger log = LoggerFactory.getLogger(BookAspect.class);

    @Pointcut("execution(* com.axinalis.library.service.BookService.*(..))")
    public void serviceMethod(){
    }

    @Before("serviceMethod()")
    public void beforeServiceMethod(JoinPoint point){
        log.debug("Service method is called with args {}", point.getArgs());
    }

    @After("serviceMethod()")
    public void afterServiceMethod(JoinPoint point){
        log.debug("Service method was executed {}", point.toString());
    }

    @Pointcut("execution(* com.axinalis.library.controller.BookController.*(..))")
    public void controllerMethod(){
    }

    @Before("serviceMethod()")
    public void beforeControllerMethod(JoinPoint point){
        log.info("Controller method is called with args {}", point.getArgs());
    }

    @After("serviceMethod()")
    public void afterControllerMethod(JoinPoint point){
        log.info("Controller method was executed {}", point.toString());
    }

}
