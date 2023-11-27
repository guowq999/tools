package com.owen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的使用
 *
 * @author wenqiang
 * @date 2023/07/10 16:10
 **/
public class FirstDemo {
    public static void main(String[] args) {
        String str = "123aaa123Bb";
        // 1、先创建一个Pattern对象， 模式对象，可以理解为是一个正则表达式对象
//        Pattern pattern = Pattern.compile("[a-zA-z]");
//        Pattern pattern = Pattern.compile("[0-9]+");
        Pattern pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)");
        // 2、创建一个匹配器对象
        Matcher matcher = pattern.matcher(str);

        // 3、可以开始循环匹配
        while (matcher.find()) {
            // 匹配内容，文本，放到m.group(0)
            System.out.println("找到：" + matcher.group(0));
            System.out.println("分组1：" + matcher.group(1));
            System.out.println("分组2：" + matcher.group(2));
        }
    }

}