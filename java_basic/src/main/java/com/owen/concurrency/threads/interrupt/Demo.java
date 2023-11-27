package com.owen.concurrency.threads.interrupt;

/**
 * @author wenqiang
 * @date 2023/06/28 15:28
 **/
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> {
            while (true) {
                System.out.println("开始");
                while (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断");
                    // break; // 不可以
                    return;
                }
//                try {
//                    Thread.sleep(3 * 1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println("结束");
            }
        };

        Runnable task2 = () -> {
            while (true) {
                System.out.println("开始");
                while (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断");

//                    try {
//                        Thread.sleep(10 * 1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                }
                System.out.println("结束");
            }
        };

        Thread thread = new Thread(task2);
        thread.start();

        Thread.sleep(2 * 1000);
        System.out.println("中断线程");
        thread.interrupt();
        System.out.println(thread.getState());


    }

}