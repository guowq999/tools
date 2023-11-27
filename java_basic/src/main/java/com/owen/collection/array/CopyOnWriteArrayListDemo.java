package com.owen.collection.array;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wenqiang
 * @date 2023/08/01 11:13
 **/
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);

        System.out.println(list.get(0));
    }
}