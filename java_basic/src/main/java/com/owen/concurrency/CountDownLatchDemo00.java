package com.owen.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * 让多个线程执行，模拟并发，让并发线程一起执行
 *
 * @author wenqiang
 * @date 2023/07/27 09:24
 **/
public class CountDownLatchDemo00 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                    String parter = "【" + Thread.currentThread().getName() + "】";
                    System.out.println(parter + "开始执行...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        Thread.sleep(2 * 1000);

        countDownLatch.countDown();
    }
}