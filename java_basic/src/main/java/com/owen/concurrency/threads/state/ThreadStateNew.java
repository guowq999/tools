package com.owen.concurrency.threads.state;

/**
 * 测试线程的状态 NEW
 *
 * @author wenqiang
 * @date 2023/07/26 10:42
 **/
public class ThreadStateNew {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("thread ...");
        });
        System.out.println(thread.getState());
    }
}