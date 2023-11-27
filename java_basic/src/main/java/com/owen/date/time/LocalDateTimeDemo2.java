package com.owen.date.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 格式化时间
 *
 * @author wenqiang
 * @date 2023/08/01 17:29
 **/
public class LocalDateTimeDemo2 {
    public static void main(String[] args) {
        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt2);
    }
}