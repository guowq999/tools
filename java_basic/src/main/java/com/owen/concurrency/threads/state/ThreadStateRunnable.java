package com.owen.concurrency.threads.state;

/**
 * 测试线程的状态 RUNNABLE
 *
 * @author wenqiang
 * @date 2023/07/26 10:43
 **/
public class ThreadStateRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("thread ...");
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
    }
}