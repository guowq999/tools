package com.owen.concurrency.threads.impl;

/**
 * 使用 implements Runnable来创建和启动一个线程
 *
 * @author wenqiang
 * @date 2023/07/26 09:59
 **/
public class RunnableDemo {
    public static void main(String[] args) {
        // ========================== 使用传统方式 ========================================
        System.out.println("main start ...");
        MyRunnable myRunnable = new MyRunnable();
        // 需要将Runable的实现类交给Thread来启动一个线程
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("main end ...");

        // =========================== 使用Java8 lambda表达式 ==============================
//        System.out.println("main start ...");
//        new Thread(() -> {
//            System.out.println("Hello Runnable lambda ...");
//        }).start();
//        System.out.println("main end ...");

    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello Runnable ...");
    }
}