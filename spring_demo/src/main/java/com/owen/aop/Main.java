package com.owen.aop;

import com.owen.config.MyAopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wenqiang
 * @date 2023/07/20 16:07
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAopConfig.class);
        MyService myService = (MyService) applicationContext.getBean("myService");
        myService.div(1,2);
    }
}