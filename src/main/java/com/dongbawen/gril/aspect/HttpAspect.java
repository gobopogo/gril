package com.dongbawen.gril.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/7 10:45
 * @modified by
 * @modify date
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //拦截方式1：
    /*@Before("execution(public * com.dongbawen.gril.controller.GrilController.*(..))")*//*可以配置到函数级别*//*
    public void deBefore(){
        System.out.println("请求前执行！！");
    }

    @After("execution(public * com.dongbawen.gril.controller.GrilController.*(..))")
    public void doAfter(){
        System.out.println("请求后拦截！！");
    }*/

    //方式2 切面
    @Pointcut("execution(public * com.dongbawen.gril.controller.GrilController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("请求前执行！！");
        //url
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}", request.getRequestURL());

        //method GET/POST
        logger.info("method={}", request.getMethod());

        //请求者 ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        //System.out.println("请求后执行！！");
        logger.info("请求后执行！！");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        //logger.info("response={}", object.toString());
    }

}
