package com.owen.date;

import java.util.Calendar;

/**
 * @author wenqiang
 * @date 2023/08/01 17:07
 **/
public class CalendarDemo {
    /**
     * Calendar多了一个可以做简单的日期和时间运算的功能
     * 返回的年份不必转换，返回的月份仍然要加1，返回的星期要特别注意，1~7分别表示周日，周日到周六
     *
     * @param args
     */
    public static void main(String[] args) {
        // 获取当前时间:
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = 1 + c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int w = c.get(Calendar.DAY_OF_WEEK); //从周日开始
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);
    }
}