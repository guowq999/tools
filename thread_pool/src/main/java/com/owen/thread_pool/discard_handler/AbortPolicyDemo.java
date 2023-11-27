package com.owen.thread_pool.discard_handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wenqiang
 * @date 2023/09/18 11:32
 **/
public class AbortPolicyDemo {
    public static void main(String[] args) throws Exception {

        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1，"线程池"的阻塞队列容量为1
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1));
        // 设置线程池的拒绝策略为"抛出异常"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            MyRunnable myRunnable = new MyRunnable("任务"+i);
            pool.execute(myRunnable);
        }
        pool.shutdown();
    }
}