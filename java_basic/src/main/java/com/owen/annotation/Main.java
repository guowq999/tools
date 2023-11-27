package com.owen.annotation;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author wenqiang
 * @date 2023/07/21 11:14
 **/
public class Main {
    public static void main(String[] args) {
        Class<FruitInfoUtil> fruitInfoUtilClass = FruitInfoUtil.class;
        Method[] methods = fruitInfoUtilClass.getMethods();
        for (Method method : methods) {
            MethodAnno annotation = method.getAnnotation(MethodAnno.class);
            if (Objects.nonNull(annotation) && annotation.flag()) {
                FruitInfoUtil.getFruitInfo(Apple.class);
            }
        }
    }
}