package com.example.springboot_demo;

import com.example.springboot_demo.domain.Users;
import com.example.springboot_demo.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    void contextLoads() {
        Users users = new Users();
        users.setId(54025L);
        users.setUsername("王五");
        int update = usersMapper.update(users);
        System.out.println(update);
    }

}
