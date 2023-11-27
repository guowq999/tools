package com.owen.string;

/**
 * 验证String在字符串常量池
 *
 * @author wenqiang
 * @date 2023/10/27 10:58
 **/
public class StringDemo {
    public static void main(String[] args) {
        String str = "hello world";
        String str1 = "hello world";
        String str2 = "hello" + " world";

        System.out.println(str == str1);
        System.out.println(str == str2);


        String s1 = "hello ";
        String s2 = "world";
        String s = s1 + s2;
        String intern = s.intern();
        System.out.println(str == s);
        System.out.println(str == intern);
    }
}