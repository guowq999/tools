package com.owen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式语法 选择匹配符
 *
 * @author wenqiang
 * @date 2023/07/11 13:54
 **/
public class RegExp02 {
    public static void main(String[] args) {
        String str = "acabacdeCDababcdakkcD";
        String regStr = "ab|cD";


        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}