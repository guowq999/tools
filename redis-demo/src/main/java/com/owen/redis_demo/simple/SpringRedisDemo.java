package com.owen.redis_demo.simple;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SpringRedisDemo {
    @Resource
    private StringRedisTemplate stringRedisTemplate;


}
