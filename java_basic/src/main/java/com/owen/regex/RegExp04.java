package com.owen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式语法 定位符
 *
 * @author wenqiang
 * @date 2023/07/11 13:58
 **/
public class RegExp04 {
    public static void main(String[] args) {
//        String str = "asdj2i%jio4wga";
//        String regStr = "^[0-9]+[a-z]*";

//        String str = "0-abc-c";
//        String regStr = "^[0-9]\\-[a-z]+$";

        String str = "owen owenaowenf";
//        String str = "owen owenaowen";
//        String regStr = "owen\\b";
        String regStr = "owen\\B";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}