package com.owen.redis_demo.redisson;

import com.owen.redis_demo.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedissonDemoTest {
    @Resource
    private RedissonClient redissonClient;

    @Test
    void testRedisson() throws InterruptedException {
        // 获取锁(可重入)，指定锁的名称
        RLock anyLock = redissonClient.getLock("anyLock");
        // 尝试获取锁，参数分别是：获取锁的最大等待时间（期间会重试），锁自动释放时间，时间单位
        boolean isLock = anyLock.tryLock(1, 10, TimeUnit.SECONDS);
        // 判断是否获取成功
        if (isLock) {
            try {
                System.out.println("获取锁成功，执行业务");
            } finally {
                // 释放锁
                anyLock.unlock();
            }
        }
    }
}
