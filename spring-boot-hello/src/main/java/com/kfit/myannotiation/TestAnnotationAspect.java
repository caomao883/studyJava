package com.kfit.myannotiation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class TestAnnotationAspect {
    @Pointcut("@annotation(com.kfit.myannotiation.MyTestAnnotation)")
    public void myAnnotationPointCut() {
    }
    @Before("myAnnotationPointCut()")
    public void before(JoinPoint joinPoint) throws Throwable {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        MyTestAnnotation annotation = method.getAnnotation(MyTestAnnotation.class);
        //获取注解参数
        System.out.println("TestAnnotation before 参数：" + annotation.value());
    }
    @Around("myAnnotationPointCut()")
    public String around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("TestAnnotation around before");
        String result = null;
        try {
            result = (String)proceedingJoinPoint.proceed();
            System.out.println("TestAnnotation around after:" + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("TestAnnotation exptect:" + result);
        }

        return result;
    }
    @After("myAnnotationPointCut()")
    public void after() {
        System.out.println("TestAnnotation after");
    }

}
