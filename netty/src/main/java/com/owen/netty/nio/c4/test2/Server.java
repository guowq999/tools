package com.owen.netty.nio.c4.test2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static com.owen.netty.util.ByteBufferUtil.debugRead;

/**
 * 使用nio来理解非阻塞模式，单线程
 *
 * 什么是阻塞模式 ： 一个事情没有发送，就阻塞在那里
 * 什么是非阻塞模式：一个事情发生没发生，都不影响线程的执行
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false); // 设置为非阻塞模式 【默认true】，影响的是accept方法

        ssc.bind(new InetSocketAddress(8080));

        List<SocketChannel> channels = new ArrayList<>();
        while (true) {
            SocketChannel sc = ssc.accept(); // 非阻塞模式下，这里不会阻塞，返回的是null
            if (sc != null) {
                System.out.println("connected..." + sc);
                sc.configureBlocking(false);
                channels.add(sc);
            }

            for (SocketChannel channel : channels) {
                int res = channel.read(byteBuffer);// 非阻塞模式下，线程任会执行，返回0
                if (res > 0) {
                    byteBuffer.flip();
                    debugRead(byteBuffer);
                    byteBuffer.clear();
                    System.out.println("after read ..." + channel);
                }
            }
        }
    }
}
