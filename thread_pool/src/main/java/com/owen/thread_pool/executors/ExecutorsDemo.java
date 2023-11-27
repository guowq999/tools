package com.owen.thread_pool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wenqiang
 * @date 2023/09/18 11:27
 **/
public class ExecutorsDemo {

    public static void main(String[] args) {

    }

    /**
     *
     * 因为线程池大小为2，每个任务输出index后sleep 2秒，所以每两秒打印2个数字。
     */
    public void fixedThreadPool() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (long i = 0; i < 10; i++) {
            final long index = i;
            fixedThreadPool.execute(new Runnable() {
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

        Thread.sleep(30000);
    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，谁先来谁先执行
     */
    public void newSingleThreadExecutor() throws InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (long i = 0; i < 10; i++) {
            final long index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + index);
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        }
        Thread.sleep(20000);
    }


    /**
     * 不缓存任务，来任务时，如果没有线程来执行任务，会创建新的线程。
     */
    public void cachedThreadPool() throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (long i = 0; i < 10; i++) {
            final long index = i;
            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + index);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(30000);
    }



    /**
     * 创建一个定长线程池，支持定时及周期性任务执行
     */
    public void newScheduledThreadPool() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":delay 5 seconds");
            }
        }, 5, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }
}