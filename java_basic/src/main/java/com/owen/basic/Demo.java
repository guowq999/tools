package com.owen.basic;

/**
 * @author wenqiang
 * @date 2023/07/01 19:04
 **/
public class Demo {

    public static void main(String[] args) {
        Byte aa = (byte) 100;
        int bb = 128000;

        Long cc = 128000L;
        System.out.println(bb == aa);
        System.out.println(bb == cc);
    }

}