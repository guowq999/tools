package com.owen.annotation;

import java.lang.annotation.*;


/**
 *
 * @author wenqiang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodAnno {
    boolean flag() default false;
}
