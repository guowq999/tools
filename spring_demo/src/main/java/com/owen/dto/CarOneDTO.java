package com.owen.dto;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author wenqiang
 * @date 2023/07/18 17:10
 **/
public class CarOneDTO implements InitializingBean, DisposableBean {

    public CarOneDTO() {
        System.out.println("CarOneDTO的构造方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("CarOneDTO的destroy方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CarOneDTO的afterPropertiesSet方法");
    }
}