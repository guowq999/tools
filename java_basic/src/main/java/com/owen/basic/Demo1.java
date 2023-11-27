package com.owen.basic;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println(opposite(-2147483647));
    }

    public static int opposite(int number) {
        return Math.negateExact(number);
    }
}
