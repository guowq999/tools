package com.example.springboot_demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AAADemo {
    @Transactional
    public void aaa() {
        System.out.println("调用a方法");
    }
}
