package com.owen.date;

import java.util.Date;

/**
 * @author wenqiang
 * @date 2023/08/01 16:58
 **/
public class DateDemo {
    /**
     * Date 通过 fastTime 来存储一个目前时刻的毫秒数
     * CST China Standard Time 也可以表示 Central Standard Time USA
     *
     * Date对象有几个严重的问题：
     * 它不能转换时区，除了toGMTString()可以按GMT+0:00输出外，D
     * ate总是以当前计算机系统的默认时区为基础进行输出。
     * 此外，我们也很难对日期和时间进行加减，计算两个日期相差多少天，计算某个月第一个星期一的日期等。
     */
    public static void main(String[] args) {
        // 获取当前时间:
        Date date = new Date();
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); // 0~11，必须加上1
        System.out.println(date.getDate()); // 1~31，不能加1
        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());
    }
}