package com.owen.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 模拟车站买票，有三个窗口，只能有三个人买，其他人等待
 * @author wenqiang
 * @date 2023/07/27 10:30
 **/
public class SemaphoreDemo00 {
    public static void main(String[] args) {
        // 三个窗口
        Semaphore semaphore = new Semaphore(3);

        // 模拟5个人购票
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    // 购票，如果没有位置则等待
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "：开始购票");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "：购票成功");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    // 释放许可，释放窗口
                    semaphore.release();
                }
            }, "Thread" + i).start();
        }
    }
}