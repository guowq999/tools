package com.owen.ext;

import com.owen.ext.dto.Blue;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author wenqiang
 * @date 2023/07/24 09:49
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Blue blue = (Blue) applicationContext.getBean("blue");

        applicationContext.publishEvent(new ApplicationEvent(new String("我发布了事件")) {
        });
        applicationContext.close();
    }
}