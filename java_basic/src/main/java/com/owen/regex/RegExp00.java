package com.owen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式语法：
 *
 * 使用正则表达式去检索某些特殊字符的时候，需要用到转义符号，否则检索不到结果，甚至会报错
 *
 * 需要使用到转义符号的字符有以下：*,.,+,(,),$,/,\,?,[,],^,{,}
 *
 * 在Java的正则表达式中，两个\\代表其他语言的一个\
 *
 * @author wenqiang
 * @date 2023/07/11 11:14
 **/
public class RegExp00 {
    public static void main(String[] args) {
        String str = "abc$(abc(123(";
//        String regStr = "abc$(";
        String regStr = "abc\\$\\(";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}