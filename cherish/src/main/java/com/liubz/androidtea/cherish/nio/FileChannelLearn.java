package com.liubz.androidtea.cherish.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

/**
 * author: created by liubaozhu on 2020/5/18
 * email: liubaozhu@baidu.com
 */
public class FileChannelLearn {


    public static void main(String[] args) {
//       getChannel();
//        try {
////            transferChannelData2();
//            bufferToText();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        getCharsets();
    }

    private static void getChannel() {
        // write a file:
        FileChannel channel;
        try {
            channel = new FileOutputStream("data.txt").getChannel();
            ByteBuffer buffer = ByteBuffer.wrap("Some text".getBytes());
            // 卸货
            channel.write(buffer);
            channel.close();

            channel = new RandomAccessFile("data.txt", "rw").getChannel();
            buffer = ByteBuffer.wrap("Some more".getBytes());
            // 卸货
            channel.write(buffer, channel.size());
            channel.close();

            channel = new FileInputStream("data.txt").getChannel();
            buffer = ByteBuffer.allocate(4 * 1024);
            channel.read(buffer);
            // 准备获取
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            channel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void transferChannelData() throws IOException {
        FileChannel in = new FileInputStream("data.txt").getChannel();
        FileChannel out = new FileOutputStream("other.txt").getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(32 * 1024);
        while (in.read(buffer) != -1) {

            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    private static void transferChannelData2() throws IOException {
        FileChannel in = new FileInputStream("data.txt").getChannel();
        FileChannel out = new FileOutputStream("other.txt").getChannel();
//        out.transferFrom(in, 0, in.size());
        in.transferTo(0, in.size(), out);
    }

    private static void bufferToText() throws IOException {
        FileChannel out = new FileOutputStream("data.txt").getChannel();
        out.write(ByteBuffer.wrap("Hello World".getBytes()));
        out.close();
        FileChannel in = new FileInputStream("data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(32 * 1024);
        in.read(buffer);
        buffer.flip();
//        System.out.println(buffer.asCharBuffer());
//        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using: " + encoding + ": " + Charset.forName(encoding).decode(buffer));

        out = new FileOutputStream("data2.txt").getChannel();
        out.write(ByteBuffer.wrap("Some Text".getBytes("UTF-16BE")));
        out.close();
        in = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        in.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        // Use a CharBuffer to write through
        out = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocate(24);
        buffer.asCharBuffer().put("Some text");
        out.write(buffer);
        out.close();
        // read and display
        in = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        in.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }

    private static void getCharsets() {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        System.out.println("size: " + map.size());

        for (Map.Entry<String, Charset> entry : map.entrySet()) {
            String csName = entry.getKey();
            System.out.print(csName);
            Iterator<String> alias = entry.getValue().aliases().iterator();
            if (alias.hasNext()) {
                System.out.print(": ");
            }
            while (alias.hasNext()) {
                System.out.print(alias.next());
                if (alias.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
