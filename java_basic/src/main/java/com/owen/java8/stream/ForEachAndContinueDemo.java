package com.owen.java8.stream;

import java.util.Arrays;
import java.util.List;

public class ForEachAndContinueDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach(s->{
            if (s > 5) {
                return;
            }
            System.out.println(s);
        });
    }
}
