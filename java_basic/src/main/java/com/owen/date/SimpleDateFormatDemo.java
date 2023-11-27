package com.owen.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wenqiang
 * @date 2023/08/01 17:01
 **/
public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        /**
         * SimpleDateFormatDemo 可以对 Date 时间进行格式化
         *
         * yyyy：年
         * MM：月
         * dd: 日
         * HH: 小时
         * mm: 分钟
         * ss: 秒
         *
         * M：输出9
         * MM：输出09
         * MMM：输出Sep
         * MMMM：输出September
         *
         */
        // 获取当前时间:
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

        // 获取当前时间:
        SimpleDateFormat sdf1 = new SimpleDateFormat("E MMM dd, yyyy");
        System.out.println(sdf1.format(date));
    }
}