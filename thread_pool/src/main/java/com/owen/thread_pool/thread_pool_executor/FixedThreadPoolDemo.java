package com.owen.thread_pool.thread_pool_executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wenqiang
 * @date 2023/07/04 14:48
 **/
public class FixedThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        for (long i = 0; i < 10; i++) {
            final long index = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        }

        while (true) {
            BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
            System.out.println(queue);
            Thread.sleep(2000);
        }

    }
}