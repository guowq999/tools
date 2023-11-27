package com.owen.generic;

/**
 * 定义一个简单的泛型类
 *
 * @author wenqiang
 * @date 2023/07/24 17:00
 **/
public class SimpleClass<T,U,K> {
    private T name;

    private U age;

    private K weight;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public U getAge() {
        return age;
    }

    public void setAge(U age) {
        this.age = age;
    }

    public K getWeight() {
        return weight;
    }

    public void setWeight(K weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "SimpleClass{" +
                "name=" + name +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}