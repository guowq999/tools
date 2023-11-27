package com.owen.aop;

import org.springframework.stereotype.Service;

/**
 * @author wenqiang
 * @date 2023/07/20 16:04
 **/
public class MyService {

    public double div(int a,int b) {
        double result = a / b;
        System.out.println("执行" + a + "除以" + b + "结果为" + result);
        return result;
    }

}