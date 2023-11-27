package com.owen.dto;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author wenqiang
 * @date 2023/07/18 17:15
 **/
public class CarTwoDTO {
    public CarTwoDTO() {
        System.out.println("CarTwoDTO的构造方法");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("CarTwoDTO的PreDestroy方法");
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("CarTwoDTO的PostConstruct方法");
    }
}