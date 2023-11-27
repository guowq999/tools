package com.owen.thread_pool.create_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wenqiang
 * @date 2023/07/04 14:34
 **/
public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("执行线程之前");
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();

        while (!futureTask.isDone()) {
            System.out.println("正在执行");
            Thread.sleep(1);
        }
        try {
            System.out.println("执行结果：" + futureTask.get());
        } catch (Exception e) {
            System.out.println("是这里吗");
        }

        System.out.println("执行线程之后");
    }

    /**
     * implements Callable
     * <p>
     * Callable 可以捕获子线程的异常
     */
    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            for (int i = 0; i < 50; i++) {
                System.out.println("执行动作：" + i);
                Thread.sleep(1);
                if (i == 25) {
                    throw new RuntimeException("执行异常");
                }
            }
            return "执行成功";
        }
    }
}

