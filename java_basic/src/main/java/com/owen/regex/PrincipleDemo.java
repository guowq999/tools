package com.owen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wenqiang
 * @date 2023/07/11 11:03
 **/
public class PrincipleDemo {

    public static void main(String[] args) {
        String str = "1998年12月8日，第二代Java平台的企业版J2EE发布。" +
                "1999年6月，Sun公司发布了第二代Java平台(简称为Java2)的3个版" +
                "本: J2ME (Java2 Micro Edition，Java2平台的微型版)，应" +
                "用于移动、无线及有限资源的环境; J2SE (Java 2 Standa" +
                "rd Edition，Java 2平台的标准版)，应用于桌面环境;J2EE (Ja" +
                "va 2Enterprise Edition，Java 2平台的企业版) ，应用34" +
                "43于基于Java的应用服务器。Java 2平台的发布，是Java发展过" +
                "程中最重要的一个里程碑，标志着Java的应用开始普及9889";

        Pattern pattern = Pattern.compile("(\\d\\d)(\\d\\d)");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
            System.out.println("分组1：" + matcher.group(1));
            System.out.println("分组2：" + matcher.group(2));
        }
    }

}