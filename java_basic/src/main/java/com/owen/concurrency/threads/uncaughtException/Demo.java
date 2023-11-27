package com.owen.concurrency.threads.uncaughtException;

/**
 * @author wenqiang
 * @date 2023/06/28 16:20
 **/
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            int a = 10/0;
        };

        Thread thread = new Thread(task1);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        thread.start();

        Thread.sleep(2 * 1000);
    }
}