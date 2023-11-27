package com.owen.config;

import com.owen.aop.MyService;
import com.owen.aop.aop.MyServiceAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wenqiang
 * @date 2023/07/20 10:11
 **/
@EnableAspectJAutoProxy
@Configuration
public class MyAopConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    public MyServiceAop myServiceAop() {
        return new MyServiceAop();
    }
}