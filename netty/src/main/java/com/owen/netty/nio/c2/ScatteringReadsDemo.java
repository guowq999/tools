package com.owen.netty.nio.c2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static com.owen.netty.contants.MyContants.DATA_TXT;
import static com.owen.netty.util.ByteBufferUtil.debugAll;

/**
 * 分散读
 */
public class ScatteringReadsDemo {
    public static void main(String[] args) {
        try (FileChannel fileChannel = new RandomAccessFile(DATA_TXT, "r").getChannel()) {
            ByteBuffer b1 = ByteBuffer.allocate(5);
            ByteBuffer b2 = ByteBuffer.allocate(5);
            ByteBuffer b3 = ByteBuffer.allocate(3);

            fileChannel.read(new ByteBuffer[]{b1,b2,b3});
            b1.flip();
            b2.flip();
            b3.flip();

            debugAll(b1);
            debugAll(b2);
            debugAll(b3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
