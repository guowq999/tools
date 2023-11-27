package com.owen.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenqiang
 * @date 2023/08/01 11:29
 **/
public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(4);
        map.put("1","1");
        map.get("1");
        System.out.println(map.size());
    }
}