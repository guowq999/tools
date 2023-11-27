package com.owen.concurrency.threads.state;

/**
 * @author wenqiang
 * @date 2023/07/26 11:17
 **/
public class ThreadStateTerminated {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("thread ...");
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());

        Thread.sleep(1 * 1000);
        System.out.println(thread.getState());
    }
}