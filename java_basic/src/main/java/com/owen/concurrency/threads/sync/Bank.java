package com.owen.concurrency.threads.sync;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wenqiang
 * @date 2023/06/28 14:30
 **/
public class Bank {

    private final double[] accounts;

    private Lock reentrantLock ;

    private Condition condition;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        reentrantLock = new ReentrantLock();
        condition = reentrantLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {

        reentrantLock.lock();
        try {
            while (accounts[from] < amount) {
                condition.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d ", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f %n", getTotalBalance());

            condition.signalAll();
        } finally {
            reentrantLock.unlock();
        }

    }

    public double getTotalBalance() {
        reentrantLock.lock();
        try {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int size() {

        return accounts.length;
    }

}