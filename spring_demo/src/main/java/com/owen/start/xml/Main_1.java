package com.owen.start.xml;

import com.owen.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * 使用XML配置文件注入Bean
 *
 * @author wenqiang
 * @date 2023/07/18 11:35
 **/
public class Main_1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
    }
}