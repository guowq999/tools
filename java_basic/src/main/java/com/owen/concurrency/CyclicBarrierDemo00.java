package com.owen.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wenqiang
 * @date 2023/07/27 10:07
 **/
public class CyclicBarrierDemo00 {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(i+1 + 1000);
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "开始等待其他线程");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "执行完毕");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(cyclicBarrier.getNumberWaiting());
        cyclicBarrier.reset();
        System.out.println(cyclicBarrier.getNumberWaiting());

        Thread.sleep(10 * 1000);
        cyclicBarrier.await();
    }
}