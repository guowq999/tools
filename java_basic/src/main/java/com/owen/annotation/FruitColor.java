package com.owen.annotation;

import java.lang.annotation.*;

/**
 * 水果颜色注解
 *
 * @author wenqiang
 * @date 2023/07/21 11:16
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色枚举
     */
    public enum Color {
        BULE,
        RED,
        GREEN
    };

    /**
     * 颜色属性
     *
     * @return
     */
    Color fruitColor() default Color.GREEN;
}