package com.owen.concurrency;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 模拟流量控制
 *
 * @author wenqiang
 * @date 2023/07/27 10:37
 **/
public class SemaphoreDemo01 {
    /**
     * 实现一个同时只能处理5个请求的限流器
     */
    private static Semaphore semaphore = new Semaphore(5);

    /**
     * 定义一个线程池
     */
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10,50,1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(200));

    public static void exec() {
        try {
            semaphore.acquire();
            // 模拟真实请求方法
            System.out.println("执行exec方法");
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release(1);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for (;;) {
            Thread.sleep(100);
            executor.execute(()->exec());
        }
    }
}