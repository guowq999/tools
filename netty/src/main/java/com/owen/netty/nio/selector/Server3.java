package com.owen.netty.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

import static com.owen.netty.util.ByteBufferUtil.debugRead;

/**
 * selector模式
 *
 * 处理read的异常情况
 */
public class Server3 {
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
                // 处理key时，要从selectedKeys集合中删除
                iterator.remove();

                // 判断监控的事件
                if (key.isAcceptable()) { // 如果是accept
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    SelectionKey scKey = sc.register(selector, 0, null);
                    scKey.interestOps(SelectionKey.OP_READ);
                    System.out.println(sc);
                } else if (key.isReadable()) { // 如果时 read
                    try {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(4);
                        int read = channel.read(buffer);
                        if (read == -1) { // 连接正常断开，也需要处理
                            key.cancel();
                        } else {
                            buffer.flip();
//                            debugRead(buffer);
                            System.out.println(Charset.defaultCharset().decode(buffer));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        // 必须要取消事件，否则一直循环
                        // 因为客户端断开了,因此需要将 key 取消(从 selector 的 keys 集合中真正删除 key)
                        key.cancel();
                    }
                }
            }
        }
    }
}
