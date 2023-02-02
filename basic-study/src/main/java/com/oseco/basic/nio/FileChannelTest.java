package com.oseco.basic.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    private static final String CONTENT = "Zero copy implemented by FileChannel";
    private static final String SOURCE_FILE = "/source.txt";
    private static final String TARGET_FILE = "/target.txt";
    private static final String CHARSET = "UTF-8";

    public static void main(String[] args) {
        try (FileChannel fromChannel = new RandomAccessFile(
                MappedByteBufferTest.class
                        .getResource(SOURCE_FILE)
                        .getPath(), "rw").getChannel();
             FileChannel toChannel = new RandomAccessFile(
                     MappedByteBufferTest.class
                             .getResource(TARGET_FILE)
                             .getPath(), "rw").getChannel()) {
            long position = 0L;
            long offset = fromChannel.size();
            fromChannel.transferTo(position, offset, toChannel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
