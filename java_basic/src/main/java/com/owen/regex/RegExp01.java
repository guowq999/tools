package com.owen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式语法 字符匹配符
 *
 * @author wenqiang
 * @date 2023/07/11 11:22
 **/
public class RegExp01 {
    public static void main(String[] args) {
        String str = "abcDeFg$(aBcDEFG)1.23 456\n789";
//        String regStr = "[abc]";
//        String regStr = "[^abc]";
//        String regStr = "[a-d]";
//        String regStr = ".";
//        String regStr = "\\.";
//        String regStr = "\\d";
//        String regStr = "\\D";
//        String regStr = "\\w";
//        String regStr = "\\W";
//        String regStr = "\\s";
//        String regStr = "\\S";
//        String regStr = "\\d\\d\\d";
//        String regStr = "\\d{3}";

        // 不区分大小写
//        String regStr = "(?i)abc";
//        String regStr = "a(?i)bc";
//        String regStr = "a((?i)b)c";

//        String regStr = "[^a-z]";
        String regStr = "[^a-z]{2}";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}