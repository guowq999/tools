package com.owen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式语法 限定符
 *
 * @author wenqiang
 * @date 2023/07/11 13:31
 **/
public class RegExp03 {
    public static void main(String[] args) {
        String str = "ababacccaccaccacc1111333333ababab555dfg2222";
//        String regStr = "(acc)*";
//        String regStr = "ab*";
//        String regStr = "a(ba)*";
//        String regStr = "ac?";
//        String regStr = "[abcd]{3}";
//        String regStr = "[abcd]{3,}";
//        String regStr = "[abcd]{3,9}";

//        String regStr = "1+";
//        String regStr = "c+";
        String regStr = "\\d+";


        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}