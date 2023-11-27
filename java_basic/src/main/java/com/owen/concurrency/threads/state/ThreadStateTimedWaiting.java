package com.owen.concurrency.threads.state;

/**
 * 测试线程的状态 TIMED_WAITING
 *
 * @author wenqiang
 * @date 2023/07/26 10:45
 **/
public class ThreadStateTimedWaiting {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("thread ...");
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());

        Thread.sleep(1 * 1000);
        System.out.println(thread.getState());
    }
}