package com.owen.generic;

/**
 * @author wenqiang
 * @date 2023/07/24 17:06
 **/
public class SimpleMethod {
   public static <T> T getMiddle(T... a) {
       if (a == null || a.length < 1) {
//           throw new RuntimeException();
           return null;
       }
       return a[a.length / 2];
   }
}