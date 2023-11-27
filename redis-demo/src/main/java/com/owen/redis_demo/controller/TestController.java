package com.owen.redis_demo.controller;

import com.owen.redis_demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test() {

        return testService.test();
    }

    @GetMapping("/lockOfVersion1Test")
    public String lockOfVersion1Test() {
        System.out.println("执行controller了嘛");

        return testService.lockOfVersion1Test();
    }

    @GetMapping("/lockOfVersion2Test")
    public String lockOfVersion2Test() {
        System.out.println("执行controller了嘛");

        return testService.lockOfVersion2Test();
    }

    @GetMapping("/lockOfVersion3Test")
    public String lockOfVersion3Test() {

        return testService.lockOfVersion3Test();
    }
}
