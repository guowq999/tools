package com.owen.serializable;

import java.io.Serializable;

/**
 * 实现Serializable接口
 *
 * @author wenqiang
 * @date 2023/08/08 10:12
 **/
public class Person implements Serializable{

    private String name;
    private int age;
    private int weight;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
    }

//    public String toString() {
//        return "Person [name=" + name + ", age=" + age + "]";
//    }
}