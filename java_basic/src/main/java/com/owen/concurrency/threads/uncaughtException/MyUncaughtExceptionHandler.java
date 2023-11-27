package com.owen.concurrency.threads.uncaughtException;

/**
 * @author wenqiang
 * @date 2023/06/28 16:19
 **/
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("执行");
    }
}