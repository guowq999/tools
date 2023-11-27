package com.owen.netty.nio.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 客户端
 *
 * 调试时 sc.write(Charset.defaultCharset().encode("hello")); debug执行语句
 *
 * 结果，服务端只会执行一次
 *
 * 因为ssc.accept是等待新的连接，这个连接只有运行到read方法服务端才会收到这个连接的消息
 *
 * 建立一个新连接，list中就有两个连接了，可以处理两个连接的数据
 *
 * 阻塞模式对于网络请求处理的不好，单线程模式下，会影响客户端的请求，一个连接阻塞在那里，必须要等下一个连接
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 8080));
        System.out.println("waiting...");

    }
}
