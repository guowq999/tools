package com.owen.java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable("有值，不是空用自己").orElse("替代值"));
        System.out.println(Optional.ofNullable(null).orElse("替代值"));

        Object value = Optional.ofNullable(null).orElseGet(() -> {
            // 例如之前的值是从Redis缓存中查询的值，没有查询到
            // 则查询数据库
            // 将值保存到redis
            // 返回值
            return "从数据库查询到的值";
        });
        System.out.println(value);

        Optional.ofNullable(null).orElseThrow(()->new RuntimeException("输入的值是空"));

        // 经常使用到list上,就不需要写list的判空代码了
        test(null);
        test1(null);
    }

    public static void test(List<Integer> list) {
        // 集合为空返回
        if (list == null || list.isEmpty()) {
            return;
        }
        // 不是空执行操作
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static void test1(List<Integer> list) {
        Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(System.out::println);
    }
}
