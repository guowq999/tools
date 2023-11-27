package com.example.springboot_demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
    public String add() {
        System.out.println("新增用户成功");
        return "新增用户成功";
    }

    @GetMapping("/delete")
    public String delete() {
        System.out.println("删除用户成功");
        return "删除用户成功";
    }

}
