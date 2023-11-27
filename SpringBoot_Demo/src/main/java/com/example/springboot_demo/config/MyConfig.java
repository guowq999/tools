package com.example.springboot_demo.config;

import com.example.springboot_demo.interceptor.InterceptorDemo;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义的拦截器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new InterceptorDemo());
        // 定义拦截所有路径
        interceptorRegistration.addPathPatterns("/**");
        // 定义排查/user/下的所有路径
        interceptorRegistration.excludePathPatterns("/user/**");
        // 确定执行顺序
        interceptorRegistration.order(1);


    }
}
