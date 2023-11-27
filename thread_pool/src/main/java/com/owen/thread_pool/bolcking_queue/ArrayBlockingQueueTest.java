package com.owen.thread_pool.bolcking_queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author wenqiang
 * @date 2023/07/04 14:42
 **/
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        arrayBlockingQueue.add("a");
        arrayBlockingQueue.add("b");
        arrayBlockingQueue.put("C");
    }
}