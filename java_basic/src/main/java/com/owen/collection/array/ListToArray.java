package com.owen.collection.array;

import java.util.Arrays;
import java.util.List;

/**
 * 将List转为数组
 *
 * @author wenqiang
 * @date 2023/07/01 13:39
 **/
public class ListToArray {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Integer[] array = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(array));
    }

}