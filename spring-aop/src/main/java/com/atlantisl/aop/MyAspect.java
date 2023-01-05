package com.atlantisl.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author dachuan
 */
@Aspect
@Component("myAspect")
public class MyAspect {

    @Before("pointcut()")
    public void before() {
        System.out.println("MyAspect before");
    }

    @Around("pointcut()")
    public Object after(ProceedingJoinPoint joinPoint) {
        System.out.println("MyAspect Around before");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Around Exception");
        }
        System.out.println("MyAspect Around after");
        return proceed;
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("aaa");
    }

    @Pointcut("execution(* com.atlantisl.aop.Target.*(..))")
    public void pointcut() {
    }
}
