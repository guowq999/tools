package com.owen.redis_demo.lock.version2;

import cn.hutool.core.lang.UUID;
import com.owen.redis_demo.lock.version1.ILock;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class SimpleRedisLockV2 implements ILock {

    /**
     * key值前缀
     */
    private static final String KEY_PREFIX = "lock";
    /**
     * value值前缀
     */
    private static final String ID_PREFIX = UUID.randomUUID().toString(true) + "-";

    private StringRedisTemplate stringRedisTemplate;

    private String name;

    public SimpleRedisLockV2(StringRedisTemplate stringRedisTemplate, String name) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.name = name;
    }

    @Override
    public boolean tryLock(long timeoutSec) {
        // 获取当前线程id
        long threadId = Thread.currentThread().getId();
        // 获取锁
        Boolean success = stringRedisTemplate.opsForValue()
                .setIfAbsent(KEY_PREFIX + name, ID_PREFIX + threadId, timeoutSec, TimeUnit.SECONDS);

        return Boolean.TRUE.equals(success);
    }

    @Override
    public void unlock() {
        // 获取当前线程id
        long threadId = Thread.currentThread().getId();
        // 获取锁中的标识
        String value = stringRedisTemplate.opsForValue().get(KEY_PREFIX + name);
        if ((ID_PREFIX + threadId).equals(value)) {
            // 释放锁
            stringRedisTemplate.delete(KEY_PREFIX + name);
        } else {
            System.out.println("释放锁失败");
        }
    }
}
