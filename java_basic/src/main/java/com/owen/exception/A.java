package com.owen.exception;

/**
 * @author wenqiang
 * @date 2023/07/01 16:33
 **/
public class A {

    public void a() {
        System.out.println("执行a方法开始");
        try {
            B b = new B();
            b.b();
        } catch (Exception e) {
            System.out.println("报错了");
        }
        System.out.println("执行a方法结束");
    }
}