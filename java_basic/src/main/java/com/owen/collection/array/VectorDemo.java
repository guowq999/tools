package com.owen.collection.array;

import java.util.Vector;

/**
 * @author wenqiang
 * @date 2023/08/01 11:10
 **/
public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);

        System.out.println(vector.get(0));
    }
}