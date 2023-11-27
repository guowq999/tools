package com.owen.netty.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.owen.netty.util.ByteBufferUtil.debugRead;

/**
 * selector模式
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 1、创建selector，管理多个channel
        Selector selector = Selector.open();

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        // 2、建立 selector 和 channel 的联系（注册）
        // SelectionKey 就是将来事件发生后，通过它可以知道事件和哪个channel的事件
        SelectionKey sscKey = ssc.register(selector, 0, null);
        // key 只关注accept事件
        sscKey.interestOps(SelectionKey.OP_ACCEPT);
        System.out.println("register key:" + sscKey);

        ssc.bind(new InetSocketAddress(8080));
        while (true) {
            // 3、select 方法，没有事件发生时，线程阻塞，又事件，线程才会恢复运行
            // select 在事件未处理时不会阻塞
            selector.select();
            // 4、处理事件，selectedKeys 内部包含了所有发生的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                System.out.println("key:{}" + key);
                ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                SocketChannel sc = channel.accept();
                System.out.println(sc);

//                key.cancel(); // 取消事件
            }
        }
    }
}
