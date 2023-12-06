package com.owen.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wenqiang
 * @date 2023/12/06 16:11
 **/
public class CollectorsToMapDemo {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Student {
        private String name;
        private Integer age;
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", 18));
        list.add(new Student("李四", 19));
        list.add(new Student("王五", 20));
        list.add(new Student("赵六", 18));

        // 将这个list转为map集合，key=age，value=student
        Map<Integer, Student> map = list.stream().collect(Collectors.toMap(Student::getAge, Function.identity(), (a,b)->b));
        System.out.println(map);
    }
}