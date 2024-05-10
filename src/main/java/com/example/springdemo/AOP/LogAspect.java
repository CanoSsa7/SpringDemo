package com.example.springdemo.AOP;

import com.alibaba.fastjson.JSONObject;
import com.example.springdemo.Dao.OperateLogMapper;
import com.example.springdemo.Entity.OperateLog;
import com.example.springdemo.Utilis.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    @Autowired
    HttpServletRequest request;
    @Autowired
    OperateLogMapper operateLogMapper;
    @Around("@annotation(com.example.springdemo.AOP.Mylog)")
    Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //从jwt中获取操作人的id
        String jwt = request.getHeader("jwt");
        Claims claims = JwtUtils.parseJWT(jwt);
        String operateUser = (String) claims.get("username");

        //获取操作的执行时间
        LocalDateTime operateTime = LocalDateTime.now();

        //获取操作类名
        String className = joinPoint.getTarget().getClass().toString();

        //获取方法名
        String methodName = joinPoint.getSignature().getName();

        //获取方法的参数
        String methodParams = Arrays.toString(joinPoint.getArgs());

        //记录开始时间
        long start = System.currentTimeMillis();
        //执行原函数
        Object obj = joinPoint.proceed();
        //记录结束时间
        long end = System.currentTimeMillis();
        //计算操作耗时
        Long costTime = end - start;
        //获取返回值，
        String returnValue = JSONObject.toJSONString(obj);

        OperateLog operateLog = new OperateLog(null, operateUser, operateTime,
                className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog); //记录操作日志

        System.out.println(operateLog.toString());
        return obj;
    }
}
