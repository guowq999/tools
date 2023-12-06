package com.owen.errorTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wenqiang
 * @date 2023/12/06 15:25
 **/
public class UnsupportedOperationExceptionDemo {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Student {
        private String name;

        private Integer age;
    }

    public static void main(String[] args) {
        // 初始化几个学生
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("张三", 18));
        studentList.add(new Student("李四", 19));
        studentList.add(new Student("王五", 18));
        studentList.add(new Student("赵六", 20));

        // 根据年龄对这个分组
//        Map<Integer, List<Student>> map = new HashMap<>();
//        for (Student student : studentList) {
//            if (map.containsKey(student.getAge())) {
//                List<Student> students = map.get(student.getAge());
//                students.add(student);
//            } else {
//                List<Student> list = new ArrayList<>();
//                list.add(student);
//                map.put(student.getAge(), list);
//            }
//        }
        Map<Integer, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(map);
    }
}