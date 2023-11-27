package com.owen.date;

import java.util.TimeZone;

/**
 * @author wenqiang
 * @date 2023/08/01 17:13
 **/
public class TimeZoneDemo {
    /**
     * Calendar和Date相比，它提供了时区转换的功能。时区用TimeZone对象表示
     * 时区的唯一标识是以字符串表示的ID,GMT+09:00、Asia/Shanghai都是有效的时区ID
     * 要列出系统支持的所有ID，请使用TimeZone.getAvailableIDs()
     *
     * 本质上时区转换只能通过SimpleDateFormat在显示的时候完成
     *
     * @param args
     */
    public static void main(String[] args) {
        TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00"); // GMT+9:00时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York"); // 纽约时区
        System.out.println(tzDefault.getID()); // Asia/Shanghai
        System.out.println(tzGMT9.getID()); // GMT+09:00
        System.out.println(tzNY.getID()); // America/New_York
    }
}