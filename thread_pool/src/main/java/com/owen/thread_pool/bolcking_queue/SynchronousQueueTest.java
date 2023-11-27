package com.owen.thread_pool.bolcking_queue;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

/**
 * @author wenqiang
 * @date 2023/07/04 14:44
 **/
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException, IOException {

        final SynchronousQueue<String> queue = new SynchronousQueue<String>(true);

        Thread put = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("put1 thread start");
                try {
                    queue.put("put1");
                } catch (Exception e) {
                }
                System.out.println("put1 thread end");
            }
        }, "put1");

        Thread take = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take1 thread start");
                try {
                    System.out.println("take1 from putThread: " + queue.take());
                } catch (Exception e) {
                }
                System.out.println("take1 thread end");
            }
        }, "take1");

        put.start();
        Thread.sleep(2000);
        take.start();
        System.in.read();
    }
}