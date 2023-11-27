package com.example.springboot_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalDemo {

    @Autowired
    private AAADemo aaaDemo;

    public void bbb() {
        System.out.println("调用b方法");
        aaaDemo.aaa();
    }
}
