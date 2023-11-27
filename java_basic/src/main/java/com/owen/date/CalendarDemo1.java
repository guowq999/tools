package com.owen.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author wenqiang
 * @date 2023/08/01 17:11
 **/
public class CalendarDemo1 {
    /**
     * Calendar只有一种方式获取，即Calendar.getInstance()，
     * 而且一获取到就是当前时间。如果我们想给它设置成特定的一个日期和时间，就必须先清除所有字段
     *
     * @param args
     */
    public static void main(String[] args) {
        // 当前时间:
        Calendar c = Calendar.getInstance();
        // 清除所有:
        c.clear();
        // 设置2019年:
        c.set(Calendar.YEAR, 2019);
        // 设置9月:注意8表示9月:
        c.set(Calendar.MONTH, 8);
        // 设置2日:
        c.set(Calendar.DATE, 2);
        // 设置时间:
        c.set(Calendar.HOUR_OF_DAY, 21);
        c.set(Calendar.MINUTE, 22);
        c.set(Calendar.SECOND, 23);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
        // 2019-09-02 21:22:23
    }
}