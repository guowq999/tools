package com.owen.netty.nio.c2;

import com.owen.netty.util.ByteBufferUtil;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 字符和ByteBuffer互转
 */
public class StringAndByteBufferConvertDemo {
    public static void main(String[] args) {
        // 将字符转为ByteBuffer
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello world");
        ByteBuffer buffer2 = Charset.forName("utf-8").encode("hello world");

        ByteBuffer buffer3 = ByteBuffer.allocate(10);
        buffer3.put("hello world".getBytes());

        ByteBuffer buffer4 = ByteBuffer.wrap("hello world".getBytes());

        ByteBufferUtil.debugAll(buffer1);
        ByteBufferUtil.debugAll(buffer2);
        ByteBufferUtil.debugAll(buffer3);
        ByteBufferUtil.debugAll(buffer4);



        CharBuffer buffer11 = StandardCharsets.UTF_8.decode(buffer1);
        System.out.println(buffer3.getClass());
        System.out.println(buffer3.toString());




    }
}
