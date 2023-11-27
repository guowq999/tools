package com.owen.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author wenqiang
 * @date 2023/07/20 16:12
 **/
@Aspect
public class MyServiceAop {

    /**
     * 抽取公共的切入点表达式
     * 1、本类引用
     * 2、其他的切面引用
     */
    @Pointcut("execution(public double com.owen.aop.MyService.div(int, int))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logStart() {
        System.out.println("方法运行之前执行");
    }

//    @Before("pointCut()")
//    public void logStart(JoinPoint joinPoint) {
//        System.out.println("方法运行之前执行");
//        Object[] args = joinPoint.getArgs();
//    }

    // 不论正常返回还是异常返回，都会执行
    @After(value = "execution(* com.owen.aop.MyService.div(..))")
    public void logEnd() {
        System.out.println("方法运行后执行");
    }

    @AfterReturning(value = "execution(* com.owen.aop.*.*(..))")
    public void logReturn() {
        System.out.println("方法运行正常返回后执行");
    }

//    @AfterReturning(value = "execution(* com.owen.aop.*.*(..))", returning = "result")
//    public void logReturn(Object result) {
//        System.out.println("方法运行正常返回后执行");
//    }

    @AfterThrowing(value = "execution(* *.*(..))")
    public void logException() {
        System.out.println("方法出现异常后执行");
    }

//    @AfterThrowing(value = "execution(* *.*(..))", throwing = "exception")
//    public void logException(Exception exception) {
//        System.out.println("方法出现异常后执行");
//    }

//    // JoinPoint必须放在第一个参数
//    @AfterThrowing(value = "execution(* *.*(..))", throwing = "exception")
//    public void logException(JoinPoint joinPoint, Exception exception) {
//        System.out.println("方法出现异常后执行");
//    }

    // 环绕通知
    @Around(value = "execution(* com.owen.aop.*.*(..))")
    public void logArround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕方法前执行");
        proceedingJoinPoint.proceed();
        System.out.println("环绕方法后执行");
    }
}