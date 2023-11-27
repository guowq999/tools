package com.owen.annotation;

import java.lang.annotation.*;

/**
 * 水果名称注解
 *
 * @author wenqiang
 * @date 2023/07/21 11:15
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}