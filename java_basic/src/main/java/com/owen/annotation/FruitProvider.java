package com.owen.annotation;

import java.lang.annotation.*;

/**
 * 水果供应者注解
 *
 * @author wenqiang
 * @date 2023/07/21 11:18
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 供应商编号
     * @return
     */
    public int id() default -1;

    /**
     * 供应商名称
     * @return
     */
    public String name() default "";

    /**
     * 供应商地址
     * @return
     */
    public String address() default "";
}