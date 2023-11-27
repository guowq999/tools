package com.owen.concurrency.threads;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wenqiang
 * @date 2023/06/28 14:30
 **/
public class Bank {

    private final double[] accounts;

    private Lock reentrantLock = new ReentrantLock();

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

//    public void transfer(int from, int to, double amount) {
//        if (accounts[from] < amount) {
//            return;
//        }
//        System.out.print(Thread.currentThread());
//        accounts[from] -= amount;
//        System.out.printf(" %10.2f from %d to %d ", amount, from, to);
//        accounts[to] += amount;
//        System.out.printf(" Total Balance: %10.2f %n", getTotalBalance());
//    }

    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        reentrantLock.lock();
        try {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d ", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f %n", getTotalBalance());
        } finally {
            reentrantLock.unlock();
        }

    }

    public double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    public int size() {

        return accounts.length;
    }

}