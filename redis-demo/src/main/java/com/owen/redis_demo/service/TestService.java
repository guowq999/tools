package com.owen.redis_demo.service;

import com.owen.redis_demo.lock.version1.SimpleRedisLockV1;
import com.owen.redis_demo.lock.version2.SimpleRedisLockV2;
import com.owen.redis_demo.lock.version3.SimpleRedisLockV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String test() {

        return "请求成功";
    }

    /**
     * version1方法
     *
     * @return
     */
    public String lockOfVersion1Test(){
        System.out.println("执行到这里了嘛");
        String name = "张三";

        // 创建锁对象
        SimpleRedisLockV1 lock = new SimpleRedisLockV1(stringRedisTemplate, name);

        // 尝试获取锁
        if (!lock.tryLock(60)) {
            return "获取锁失败";
        }
        try {
            Thread.sleep(10 * 1000);

            return "请求执行成功";
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    /**
     * version2方法
     *
     * @return
     */
    public String lockOfVersion2Test(){
        System.out.println("执行到这里了嘛");
        String name = "张三";

        // 创建锁对象
        SimpleRedisLockV2 lock = new SimpleRedisLockV2(stringRedisTemplate, name);

        // 尝试获取锁
        if (!lock.tryLock(6)) {
            return "获取锁失败";
        }
        try {
            Thread.sleep(10 * 1000);

            return "请求执行成功";
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    /**
     * version3方法
     *
     * @return
     */
    public String lockOfVersion3Test(){
        System.out.println("执行到这里了嘛");
        String name = "张三";

        // 创建锁对象
        SimpleRedisLockV3 lock = new SimpleRedisLockV3(stringRedisTemplate, name);

        // 尝试获取锁
        if (!lock.tryLock(6)) {
            return "获取锁失败";
        }
        try {
            Thread.sleep(5 * 1000);

            return "请求执行成功";
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}
