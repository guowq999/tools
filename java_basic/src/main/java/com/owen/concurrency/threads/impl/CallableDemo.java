package com.owen.concurrency.threads.impl;

import java.util.concurrent.*;

/**
 * 使用 implements Callable 来创建一个线程并启动
 *
 * @author wenqiang
 * @date 2023/07/26 10:02
 **/
public class CallableDemo {
    /**
     * 使用 FutureTask的方式来运行 Callable
     */
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println("main start ...");
//        MyCallable myCallable = new MyCallable();
//        FutureTask<String> futureTask = new FutureTask<>(myCallable);
//        // FutureTask 实现了Runnable接口，传给Thread去执行即可
//        Thread thread = new Thread(futureTask);
//        thread.start();
//
//        while (!futureTask.isDone()) {
//            System.out.println("Callable 线程正在运行");
//            Thread.sleep(1 * 1000);
//        }
//        System.out.println("Callable return result: " + futureTask.get());
//        System.out.println("main end ...");
//    }

    /**
     * 使用线程池的方式来运行 Callable
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("main start ...");

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());

        while (!future.isDone()) {
            System.out.println("Callable 线程正在运行");
            Thread.sleep(1 * 1000);
        }
        System.out.println("Callable return result: " + future.get());
        System.out.println("main end ...");
    }
}

/**
 * implements Callable 接口创建线程可以有返回值，可以抛出异常
 */
class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Hello callable ...");
        Thread.sleep(3 * 1000);
        return "Callable end ...";
    }
}