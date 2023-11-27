package com.owen.thread_pool.create_thread;

/**
 * @author wenqiang
 * @date 2023/07/04 14:31
 **/
public class RunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("执行线程之前");
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        Thread.sleep(10);
        System.out.println("执行线程之后");
    }

    /**
     * implements Runnable
     *
     * Runnable 子线程抛出异常，子线程中断，主线程不知道正常执行
     */
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("执行动作：" + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (i == 25) {
                    throw new RuntimeException("执行异常");
                }
            }
        }
    }
}

