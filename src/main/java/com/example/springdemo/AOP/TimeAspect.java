package com.example.springdemo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect { //切面类


    @Around("execution(* com.example.springdemo.Service.*.*(..)) ") //切入点表达式确定包括的方法
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //ProceedingJoinPoint: 连接点, 包含了和切入相关的很多信息。比如切入点的对象，方法，属性等
        //只有@Around能用ProceedingJoinPoint
        long begin = System.currentTimeMillis();
        Object obj = joinPoint.proceed(); //调用原方法
        long end = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature()+"方法耗时" + (end-begin)+"ms" );
        return obj;
    }

    @Before("@annotation(com.example.springdemo.AOP.Mylog)")
    void recordByAnnotation(JoinPoint joinPoint){
        System.out.println("执行切入类中的方法" + joinPoint.getSignature());
    }
}
