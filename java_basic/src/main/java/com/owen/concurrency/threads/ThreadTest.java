package com.owen.concurrency.threads;

import java.util.concurrent.Callable;

/**
 * @author wenqiang
 * @date 2023/06/25 17:01
 **/
public class ThreadTest {

    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        System.out.println(myThread.getState());
//
//        myThread.start();
//        System.out.println("==============");
//
//        Thread thread = new Thread(new MyRunnable());
//        thread.start();
//    }

    public static void main(String[] args) {
        Bank bank = new Bank(4, 1000000);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0,1,amount);
                    Thread.sleep((long) (DELAY*Math.random()));
                }
            } catch (InterruptedException e) {

            }
        };

        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0,1,amount);
                    Thread.sleep((long) (DELAY*Math.random()));
                }
            } catch (InterruptedException e) {

            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }

}

// 都是通过Thread的start方法启动线程的

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello Thread");
    }
}

// 函数式接口，没有返回值
// 搭配Thread来使用
// lambda
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello Runnable");
    }
}

// 函数式接口，可以返回值和抛出异常
// 要搭配Future来使用
class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return "hello world";
    }
}