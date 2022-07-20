package com.example.demo.shared.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VerifyAgeAspect {

    @Around("@annotation(VerifyAge)")
    public Object verifyAge(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Integer age =(Integer) proceedingJoinPoint.getArgs()[0];

        if(age>30)
        {
            System.out.println("Student have age more than 30  " +age);
            return  "Student have age more than 30  i.e " +age;

        }
        Object result = proceedingJoinPoint.proceed();

        System.out.println(result);
        return  result;
    }
}
