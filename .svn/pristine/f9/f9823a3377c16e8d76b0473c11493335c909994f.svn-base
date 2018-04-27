package com.tmtc.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Function:
 *
 * @auther: hbwhypw
 * Date: 2015/10/22 15:19
 */
//@Aspect
//@Component
public class ControllerLogAspect {

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void cutController(){
    }

    @Around("cutController()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable{
        return point.proceed();
    }

}
