package com.owen.concurrency.threads.daemon;

import java.time.LocalTime;

/**
 * @author wenqiang
 * @date 2023/07/26 11:40
 **/
public class TimerThread extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}