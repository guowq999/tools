package com.owen.netty.nio.c2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static com.owen.netty.contants.MyContants.DATA_TXT;

/**
 * 将data.txt文件下的内容读取打印
 */
public class ChannelDemo {
    public static void main(String[] args) {
        // 得到FileChannel
        // 1、输入输出流 2、RandomAccessFile
        try (FileChannel fileChannel = new FileInputStream(DATA_TXT).getChannel()) {
            // 准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            // 从channel读取数据，写入buffer
            while (fileChannel.read(buffer) != -1) { // read 有返回值，-1表示channel中没有内容了
                // 打印buffer内容
                // buffer切换到读模式
                buffer.flip();
                while (buffer.hasRemaining()) { // 是否还有剩余未读数据
                    byte cur = buffer.get();
                    System.out.println("实际字节：" + (char) cur);
                }
                // 切换至写模式
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
