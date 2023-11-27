package com.owen.concurrency.threads.impl;

/**
 * 使用 extends Thread来创建并启动一个多线程
 *
 * @author wenqiang
 * @date 2023/07/26 09:55
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("main start ...");
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("main end ...");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello Thread...");
    }
}