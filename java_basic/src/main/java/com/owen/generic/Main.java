package com.owen.generic;

/**
 * @author wenqiang
 * @date 2023/07/24 17:01
 **/
public class Main {

    public static void main(String[] args) {
        // 测试简单的泛型类
//        SimpleClass<String, Integer, Double> simple = new SimpleClass<>();
//        simple.setName("张三");
//        simple.setAge(18);
//        simple.setWeight(60.0);
//        System.out.println(simple);

        // 测试简单的泛型方法
//        Integer middle = SimpleMethod.<Integer>getMiddle(1,2,3);
//        System.out.println(middle);

        // 测试简单的泛型变量
        Integer[] arr = {4,3,2,1};
//        SimpleMethod[] arr = {new SimpleMethod(), new SimpleMethod(), new SimpleMethod()};
        Integer min = SimpleVar.<Integer>min(arr);
        System.out.println(min);
    }
}