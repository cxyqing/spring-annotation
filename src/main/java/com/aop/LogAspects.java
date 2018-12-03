package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;


@Aspect
public class LogAspects {

    @Pointcut("execution (* com.aop..*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("logBefore " + methodName + " invoke with " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void logAfter(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("logAfter " + methodName + " invoke with " + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterThrowing(pointcut = "pointCut()",throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("logAfterThrowing " + methodName + " invoke with " + Arrays.toString(joinPoint.getArgs()) + " throwing: " + ex.getMessage());
    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("logAfterReturning " + methodName + " invoke with " + Arrays.toString(joinPoint.getArgs()) + " get result: " + result);
    }
}
