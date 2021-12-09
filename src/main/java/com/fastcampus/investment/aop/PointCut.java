package com.fastcampus.investment.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCut {

    @Pointcut("execution(* com.fastcampus.investment.component.service.*.*(..))")
    public void servicePointCut(){}

    @Pointcut("execution(* com.fastcampus.investment.component.api.*.*(..))")
    public void apiPointCut(){}
}
