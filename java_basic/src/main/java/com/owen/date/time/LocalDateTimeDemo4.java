package com.owen.date.time;

import java.time.LocalDateTime;

/**
 * 直接修改年月日
 *
 * 调整年：withYear()
 * 调整月：withMonth()
 * 调整日：withDayOfMonth()
 * 调整时：withHour()
 * 调整分：withMinute()
 * 调整秒：withSecond()
 *
 * @author wenqiang
 * @date 2023/08/01 17:33
 **/
public class LocalDateTimeDemo4 {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt);
        // 日期变为31日:
        LocalDateTime dt2 = dt.withDayOfMonth(31);
        System.out.println(dt2); // 2019-10-31T20:30:59
        // 月份变为9:
        LocalDateTime dt3 = dt2.withMonth(9);
        System.out.println(dt3); // 2019-09-30T20:30:59
    }
}