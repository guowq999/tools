package com.owen.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author wenqiang
 * @date 2023/07/25 09:46
 **/
public abstract class BaseDao<T>{
    public BaseDao() throws InstantiationException, IllegalAccessException {
//        Class<? extends BaseDao> aClass = this.getClass();
        Class clazz = this.getClass();
        ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
        Class clazzz = (Class) pt.getActualTypeArguments()[0];
        System.out.println(clazzz);
    }
}