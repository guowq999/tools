package com.owen.concurrency.threads.state;

/**
 * 测试线程的状态 WATIING
 *
 * @author wenqiang
 * @date 2023/07/26 11:12
 **/
public class ThreadStateWaiting {
    public static void main(String[] args) throws InterruptedException {
        DemoWaiting demo = new DemoWaiting();
        Thread thread1 = new Thread(() -> {
            demo.method();
        });
        Thread thread2 = new Thread(() -> {
            demo.method();
        });
        System.out.println("thread1 state: " + thread1.getState());
        System.out.println("thread2 state: " + thread2.getState());

        thread1.start();
        thread2.start();

        Thread.sleep(1 * 1000);
        System.out.println("thread1 state: " + thread1.getState());
        System.out.println("thread2 state: " + thread2.getState());
    }
}

class DemoWaiting {
    public void method() {
        System.out.println("method start ...");
        synchronized (this) {
            System.out.println("synchronized start ...");
            try {
                // 同步代码块内调用wait方法，线程会进入waiting状态并释放锁
                this.wait();
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("synchronized end ...");
        }
        System.out.println("method end ...");
    }
}