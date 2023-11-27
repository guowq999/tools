package com.owen.thread_pool.create_thread;

/**
 * @author wenqiang
 * @date 2023/07/04 14:27
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("执行线程之前");
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("执行线程之后");
    }

    /**
     * extends Thread
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("执行动作：" + i);
            }
        }
    }
}

