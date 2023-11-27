package com.owen.concurrency.threads.daemon;

/**
 * 测试守护线程
 * 在classes文件下，执行 java com.owen.concurrency.threads.daemon.Main
 *
 * @author wenqiang
 * @date 2023/07/26 13:18
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TimerThread timerThread = new TimerThread();
        timerThread.setDaemon(true);
        timerThread.start();

        new Thread(()->{
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        System.out.println("主线程结束");
    }

}