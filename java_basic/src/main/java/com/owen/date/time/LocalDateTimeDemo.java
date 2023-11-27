package com.owen.date.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author wenqiang
 * @date 2023/08/01 17:20
 **/
public class LocalDateTimeDemo {
    /**
     * ISO 8601规定的日期和时间分隔符是T
     *
     * 注意到LocalDateTime无法与时间戳进行转换，因为LocalDateTime没有时区，
     * 无法确定某一时刻。后面我们要介绍的ZonedDateTime相当于LocalDateTime加时区的组合，它具有时区，
     * 可以与long表示的时间戳进行转换。
     *
     * @param args
     */
    public static void main(String[] args) {
        LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印

        // 为了保证获取到同一时刻的日期和时间
        LocalDateTime dt1 = LocalDateTime.now(); // 当前日期和时间
        LocalDate d1 = dt.toLocalDate(); // 转换到当前日期
        LocalTime t1 = dt.toLocalTime(); // 转换到当前时间
    }
}