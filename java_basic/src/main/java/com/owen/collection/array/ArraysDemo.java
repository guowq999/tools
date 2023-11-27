package com.owen.collection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wenqiang
 * @date 2023/06/25 09:58
 **/
public class ArraysDemo {

    public static void main(String[] args) {
        // List 转换为 数组
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        // 直接转就转为Object
//        Object[] array = list.toArray();

        // Call to 'toArray()' with pre-sized array argument 'new Integer[list.size()]'
//        Integer[] array = list.toArray(new Integer[list.size()]);

        // 使用空数组和list.size()是等价的，更优
        Integer[] array = list.toArray(new Integer[0]);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

}