package com.owen.ext.dto;

/**
 * @author wenqiang
 * @date 2023/07/24 09:42
 **/
public class Blue {
    private String color;

    public Blue() {
        System.out.println("Blue的构造方法");
    }

    public String getColor() {
        System.out.println("Blue的getColor方法");
        return color;
    }

    public void setColor(String color) {
        System.out.println("Blue的setColor方法");
        this.color = color;
    }

    @Override
    public String toString() {
        return "Blue{" +
                "color='" + color + '\'' +
                '}';
    }
}