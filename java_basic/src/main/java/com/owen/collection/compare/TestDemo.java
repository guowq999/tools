package com.owen.collection.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wenqiang
 * @date 2023/11/01 13:48
 **/
public class TestDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三",33));
        list.add(new Student("张三", 20));
        list.add(new Student("张三", 18));
        list.add(new Student("张三", 25));
        list.add(new Student("张三", 21));
        list.add(new Student("张三", 35));

        Collections.sort(list);
        System.out.println(list);


//        Collections.sort(list, new StudentComparator());
        list.sort(new StudentComparator());
        System.out.println(list);
    }
}