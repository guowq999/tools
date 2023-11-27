package com.owen.netty.nio.c4.test1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static com.owen.netty.util.ByteBufferUtil.debugRead;

/**
 * 使用nio来理解阻塞模式，单线程
 *
 * 什么是阻塞模式 ： 没有连接就阻塞在那里，没有输入就阻塞在那里
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 0、ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        // 1、创建一个服务端连接
        ServerSocketChannel ssc = ServerSocketChannel.open();

        // 2、绑定监听端口
        ssc.bind(new InetSocketAddress(8080));

        // 3、连接集合
        List<SocketChannel> channels = new ArrayList<>();
        while (true) {
            // 4、accept 建立与客户端的连接，SocketChannel用来与客户端之间通信
            System.out.println("connecting...");
            SocketChannel sc = ssc.accept(); // 阻塞方法，停止运行
            System.out.println("connected..." + sc);
            channels.add(sc);

            for (SocketChannel channel : channels) {
                // 5、接受客户端发送的数据
                System.out.println("before read ..." + channel);
                channel.read(byteBuffer); // 阻塞方法，线程停止运行
                byteBuffer.flip();
                debugRead(byteBuffer);
                byteBuffer.clear();
                System.out.println("after read ..." + channel);
            }
        }
    }
}
