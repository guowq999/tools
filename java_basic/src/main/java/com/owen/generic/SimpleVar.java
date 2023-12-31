package com.owen.generic;

/**
 * @author wenqiang
 * @date 2023/07/24 17:13
 **/
public class SimpleVar {

//    public static <T> T min(T[] a) {
//        if (a == null || a.length == 0) return null;
//        T smallest = a[0];
//        for (int i = 0; i < a.length; i++) {
//            if (smallest.compareTo(a[i]) > 0) smallest = a[i];
//        }
//        return smallest;
//    }
//
    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) return null;
        T smallest = a[0];
        for (int i = 0; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) smallest = a[i];
        }
        return smallest;
    }
}