package com.owen.collection.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wenqiang
 * @date 2023/07/13 16:19
 **/
public class LinkedListDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(2));
    }
}